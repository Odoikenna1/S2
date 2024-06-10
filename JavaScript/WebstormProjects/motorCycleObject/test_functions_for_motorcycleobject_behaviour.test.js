const {checkStateOfEngine, startEngine} =require("./MotorBike");
const MotorBike = require("./MotorBike");

let newbike;

beforeAll(() => {
    newbike = new MotorBike;
})

test('test_check_stateOfEngine', () => {
    expect(newbike.getStateOfEngine()).toBeFalsy();
})

test ('test_checkThat_startEngineIs_working', () => {
    newbike.startEngine();
    expect(newbike.getStateOfEngine()).toBeTruthy()
});
test('test_check_that_stopEngineIs_working', () =>{
    newbike.startEngine();
   newbike.stopEngine();
   expect(newbike.getStateOfEngine()).toBeFalsy();
});
test('test_check_that_clutch_is_engaged', () => {
    newbike.startEngine();
    newbike.pullClutch("pull");
    let answer = newbike.getStateOfClutch();
    expect(answer).toBeTruthy();
});
test('test_check_that_clutch_is_not_engaged', () => {
    newbike.startEngine();
    newbike.pullClutch("release");
    expect(newbike.getStateOfClutch()).toBeFalsy();
})
test('test_check_that_clutch_is_not_engaged_when_engineIsOff', () => {
    newbike.pullClutch("pull");
    expect(newbike.getStateOfClutch()).toBeFalsy();
});
test('test_check_that_clutch_is_engaged_when_engineIsOn', () => {
    newbike.startEngine();
    newbike.pullClutch("pull");
    expect(newbike.getStateOfClutch()).toBeTruthy();
}); 