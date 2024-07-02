const {findTestScoresAboveSeventy, increaseTestScoresByFive, findSquaresOfNumbers, distributeBooks, sortTimeTable, sumValuesInObj} = require('./arrTasks');

test("test_findTestScoresAboveSeventy", () => {
    let testScores = [55, 65, 83, 65, 60, 72, 54, 24,60, 35];
    let answer= findTestScoresAboveSeventy(testScores);
    expect(answer).toEqual([83, 72]);
});

test("test_increaseTestScoresByFive", () =>{
    let testScores = [55, 65, 83, 65, 60, 72, 54, 24,60, 35];
    let answer = increaseTestScoresByFive(testScores);
    expect(answer).toEqual([60, 70, 88, 70, 65, 77, 59, 29,65, 40]);
});

test("test_findSquaresOfNumbers", () => {
    let lstOfNumbers = [2, 6, 8, 10];
    let answer = findSquaresOfNumbers(lstOfNumbers);
    expect(answer).toEqual([4, 36, 64, 100]);
})
test("test_distributeBooks", () => {
    let lstOfMemebers = ["Emily","Jack","Sophia","Daniel"];
    let answer= distributeBooks(lstOfMemebers);
    expect(answer).toEqual({
        "sci-fi" : [ 'Emily' ],
        documentary: [ 'Jack' ],
        thriller: [ 'Sophia' ],
        drama: [ 'Daniel' ]
    });
})
test("test_sortTimeTable", () => {
    let timeSchedule = ["9:00am", "11:00am", "1:00pm", "3:00pm", "5:00pm"];
    let answer = sortTimeTable(timeSchedule);
    expect(answer).toEqual([ '1:00pm', '3:00pm', '5:00pm']);
})
test("test_sumValuesInObj", () => {
    let expenseObj = {
        "groceries": 150,
        "dining out": 100,
        "transportation": 50,
        "entertainment": 80
    };
    let answer = sumValuesInObj(expenseObj);
    expect(answer).toEqual(380);
})