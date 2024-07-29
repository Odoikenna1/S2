class Stack{
    constructor() {
        this.arr = [];
    }
    push(value){
         this.arr.push(value);
        return this.getArray();
    }
    pop(){
        this.arr.pop();
        return this.getArray();
    }
    peek(){
        return this.arr[0];
    }
    isEmpty(){
        return this.arr.length <= 1;
    }
    getArray(){
        return this.arr;
    }

    reverseArray(array) {
        let newArr = [];
        for(let i = 0; i < array.length; i++){
            newArr[i] = array.unshift(array[i]);
        }

        return newArr;
    }
}

module.exports = Stack;