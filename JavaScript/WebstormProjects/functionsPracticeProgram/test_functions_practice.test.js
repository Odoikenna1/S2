const {calculateArea,convertToFahrenheit, isEven, isLeapYear, countVowels} =require("./functionspractice");
//const test = require("node:test");


test ('test_thatFunctionCanFindThe_AreaOfA_Rectangle', () => {
    let answer = calculateArea(5,5);
    expect(answer).toBe(25);

});
test('test_ThatFunctionCan_ConvertToFahrenheit', () => {
    let answer = convertToFahrenheit(37);
    expect(answer).toBe(98.6);
});
test('test_ThatFunctionCanDetermineNumberInput_IsEven', () => {
    let answer = isEven(14);
    expect(answer).toBeTruthy();
});
test('test_ThatFunctionCanDetermineNumberInput_IsFalse', () => {
    let answer = isEven(15);
    expect(answer).toBeFalsy();
});
test('test_ThatFunctionCanDetermineIfYear_isLeapYear', () => {
    expect(isLeapYear(2020)).toBeTruthy();
});
test('test_ThatFunctionCanDetermineIfYear_isNotLeapYear', () => {
    expect(isLeapYear(2027)).toBeFalsy();
});
test('test_ThatFunctionCan_CountVowelsInWordArgument', () => {
    expect(countVowels("shane")).toBe(2);
});