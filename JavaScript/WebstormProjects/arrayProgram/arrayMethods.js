let arrayOfNumbers = [1,23,5,3,3,6,7];
arrayOfNumbers.forEach((number) => {let answer = number * 2; console.log(answer);});

let arrayOfNames = ["Dave", "Mav"];

console.log(arrayOfNumbers.concat(arrayOfNames));

let answer = arrayOfNumbers.filter((number) => {
    return number > 3;
});
console.log(answer);