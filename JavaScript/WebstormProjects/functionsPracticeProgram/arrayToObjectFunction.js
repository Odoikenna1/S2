// let grades = [95, 78, 85, 60, 45, 91];
//
// let result = grades.map((operation) => {
//     if(operation >= 90 && operation <= 100) {return "A";}
//     if(operation >= 80 && operation <= 89) {return "B";}
//     if(operation >= 70 && operation <= 79) {return "C"}
//     if(operation >= 60 && operation <= 69) {return "D"}
//     if(operation < 60) {return "F"}
//     return operation;
// })
//
// console.log(result);

// let arrayOfNumbers2 = [2,3,5,3,3,2,5];
//
// const newObject = new Map();
// let counter = 0;
// for (let key in arrayOfNumbers2){
//     if (arrayOfNumbers2[key]) {
//         newObject.set(arrayOfNumbers2[key], counter+=1)
//         counter = 0;
//     }
//     else {
//         newObject.set(arrayOfNumbers2[key], counter)
//         // counter = 0;
//     }
// }
// console.log(newObject)

// let input = [4, 6, 9];
// let outputArray = [];
// let remainder = 0;
// for(let i = 0; i < input.length; i++){
//     for(let j = 0; j < input.length; j++){
//         remainder = input[i] / j;
//         if(input[i] % remainder  === 0
//         ){
//             outputArray[i] = remainder;
//             outputArray[i +1] = j;
//         }
//     }
// }
// console.log(outputArray);


let arr = ["apple", "carrot", "orange"];

arr.slice(0, 1);
console.log(arr);