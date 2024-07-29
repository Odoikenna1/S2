const  {addConsecutiveNumbers} = require('./addConsecutiveNumbers');

test("test_addConsecutiveNumbers", () => {
    let input = [2,5,4,1,2,3];
    let answer= addConsecutiveNumbers(input);
    expect([7,5,5]).toEqual(answer);
});