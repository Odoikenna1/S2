const Stack = require("./stack")

test('test_ThatSTackCan_PushAnElementIn', () => {
    const numberStack = new Stack();
    expect(numberStack.push(8)).toEqual([8]);
});
test('test_ThatStackCanPopOut_LastElementFirst', () => {
    const numberStack = new Stack();
    numberStack.push(9);
    numberStack.push(3);
    numberStack.pop();
    console.log(numberStack.getArray());
    expect(numberStack.getArray()).toEqual([9]);
})

test('test_thatStackCanPeek', () => {
    const numberStack = new Stack();
    numberStack.push(9);
    numberStack.push(3);
    numberStack.push(2);
    numberStack.push(1);
    console.log(numberStack.peek());

    let x= numberStack.arr[0]
    expect(numberStack.peek()).toEqual(x)
})
test('test_isEmpty', () => {
    const numberStack = new Stack();
    let ans = numberStack.isEmpty();
    expect(ans).toBeTruthy();
});
test('test_reverseArray', () => {
    const numberStack = new Stack();
    let arr = [1,2,3,4,5,6]
    let ans = numberStack.reverseArray(arr);
    expect(ans).toEqual([6,5,4,3,2,1]);
});