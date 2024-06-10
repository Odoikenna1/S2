class ArrayOperations{
    word;
    reversedWordInArray;
    constructor() {
         this.word = "semicolon";
         this.reversedWordInArray = [];
    }
     sliceAndReverse(){
        for (let i = this.word.length -1; i >= 0; i--){
            this.reversedWordInArray.push((this.word)[i]);
        }
        console.log(this.reversedWordInArray);
    }
}
module.exports = ArrayOperations;