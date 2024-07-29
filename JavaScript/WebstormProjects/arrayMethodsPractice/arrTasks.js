let students = 10;
let testScores = [55, 65, 83, 65, 60, 72, 54, 24,60, 35];
let lstOfNumbers = [2, 6, 8, 10];
let lstOfMembers = ["Emily","Jack","Sophia","Daniel"];
let timeSchedule = ["9:00am", "11:00am", "1:00pm", "3:00pm", "5:00pm"];
let expenseObj = {
    "groceries": 150,
    "dining out": 100,
    "transportation": 50,
    "entertainment": 80
};

function findTestScoresAboveSeventy(testScores){
    return testScores.filter((filterGradesAboveSeventy) => {
        return filterGradesAboveSeventy >= 70;
    });
}
function increaseTestScoresByFive(testScores){
    return testScores.map((increaseGrades) => {
        return increaseGrades += 5;
    });
}
function findSquaresOfNumbers(lstOfNumbers){
    return lstOfNumbers.map((lstOfNumber) => {
        return lstOfNumber * lstOfNumber;
    });
}

function distributeBooks(arr){
    let lstOfBooks = ["sci-fi","documentary","thriller","drama"];
    let booksAssigned = {}
    count = 0;
    for(let person of arr){
        booksAssigned[lstOfBooks[count]] = [arr[count]];
        count++;
    }
    return booksAssigned;
}
function sortTimeTable(timeSchedule){
    return timeSchedule.filter((removeNoonTime) => {
        return removeNoonTime > "12:00pm" && removeNoonTime <= "5:00pm";
    });
}

function sumValuesInObj(expenseObj){
    let sum =0;
    for(let c in expenseObj){
        sum += expenseObj[c] ;
    }
    return sum;
}


console.log(findTestScoresAboveSeventy(testScores));
console.log(increaseTestScoresByFive(testScores));
console.log(findSquaresOfNumbers(lstOfNumbers));
console.log(distributeBooks(lstOfMembers));
console.log(sortTimeTable(timeSchedule));
console.log(sumValuesInObj(expenseObj))

module.exports = {findTestScoresAboveSeventy, increaseTestScoresByFive, findSquaresOfNumbers, distributeBooks, sortTimeTable, sumValuesInObj}