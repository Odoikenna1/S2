const {removedDuplicate} = require('./removeDuplicates');

test("test_removeDuplicate", () => {
    let arr = [1,1,2,3,3,4];
    let answer = removedDuplicate(arr);
    expect(answer).toEqual([1,2,3,4]);
});