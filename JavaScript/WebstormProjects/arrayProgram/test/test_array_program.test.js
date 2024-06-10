const ArrayProgram =require("../arrayProgram");

test('test_thatDisplayArrayElements_Work', () => {
    const x = new ArrayProgram();
    expect(x.list.arrayOfNumbers).toEqual(arrayProgram.displayOriginalArray());
})
test('test_that_ProductOfArrayElements_are_correct', () => {
    const x = new ArrayProgram();
    x.findProductOfArrayElements();
    expect(x.productOfNewArray).toEqual(x.getProductOfNewArray())
})
