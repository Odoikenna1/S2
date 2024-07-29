class ArrayProgram{
    productOfNewArray = [];
    constructor(){
        this.list = {
            arrayOfNumbers: [2,3,5,3,5,3,2],
        };
    }
    displayOriginalArray()
    {
        return this.list.arrayOfNumbers;
    }
    findProductOfArrayElements()
    {
        let originalArray= this.list.arrayOfNumbers.length;
        for(let i = 0; i < originalArray.length; i++)
        {
            this.productOfNewArray[i] = originalArray[i] * 2;
        }
    }
    getProductOfNewArray()
    {
        return this.productOfNewArray;
    }
}
module.exports = ArrayProgram;