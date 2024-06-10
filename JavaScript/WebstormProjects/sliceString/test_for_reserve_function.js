const ArrayOperations = require("./sliceAndReverse");

test('test_ThatString_HasBeenSliced', () => {
    const arrayOperationsObject = new ArrayOperations();
    arrayOperationsObject.sliceAndReverse();
    let expectedResult = ["n","o","l","o","c","i","m","e","s"];
    expect(expectedResult).toBe(getReverseOfStringInArray());
})