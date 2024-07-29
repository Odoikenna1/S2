let arr = [1,1,2,3,3,4];
let arr2 = [6,7,6,8,7,9];
let a = new Set();

function removedDuplicate(arr){
    let aArr = [];
    for(let i = 0; i < arr.length; i++){
        a.add(arr[i]);
    }
    let i = 0;
    for(let values of a){
        aArr[i] = values;
        i++;
    }
    return aArr;
}
console.log(removedDuplicate(arr));
module.exports = {removedDuplicate}
















// function removeDuplicates(arr){
//     let temp= 0;
//     for (let i = 0; i < arr.length; i++) {
//         if (arr[i] === arr[i+1]) {
//             temp = arr[i];
//             arr[i] = arr[i] + arr[i+1];
//             arr[i] = arr[i] - temp;
//         }
//         else{
//             arr[i] = arr[i+1];
//         }
//     }
//     return arr;
// }
// console.log(removeDuplicates(arr2));