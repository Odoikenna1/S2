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

let findElements = testScores.filter((filterGradesAboveSeventy) =>{
         return filterGradesAboveSeventy >= 70;
});
let result = testScores.map((increaseGrades) => {
    return increaseGrades += 5;
});
let squareOfArrNumbers = lstOfNumbers.map((lstOfNumber)=>{
    return lstOfNumber * lstOfNumber;
});
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
let timelstForMorningSchedule = timeSchedule.filter((removeNoonTime) => {
    return removeNoonTime > "12:00pm" && removeNoonTime <= "5:00pm";
});
function sumValuesInObj(expenseObj){
    let sum =0;
    for(let c in expenseObj){
        sum += expenseObj[c] ;
    }
    return sum;
}


console.log(result);
console.log(findElements);
console.log(squareOfArrNumbers);
console.log(distributeBooks(lstOfMembers));
console.log(timelstForMorningSchedule);
console.log(sumValuesInObj(expenseObj))