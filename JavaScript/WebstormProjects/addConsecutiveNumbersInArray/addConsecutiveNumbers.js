let arr = [2,5,4,1,2,3];
function addConsecutiveNumbers(arr) {
    let newArr = [];
    let count = 0;
    for(let i = 0; i < arr.length; i+=2) {
        newArr[count] = arr[count] + arr[count +1];
        count++;
    }
    return newArr;
}
console.log(addConsecutiveNumbers(arr));
module.exports = {addConsecutiveNumbers};
