let animal = {
    name : "unknown",
    color: "blue",
    sound : function(){
        return (`${this.name} made this sound`)
    },
    move : function(numberOfSteps){
        return (`Hi, I am ${this.name} and I am moving forward ${numberOfSteps} steps`)
    }
}

let cat = Object.create(animal);

cat.name = "Jane";
console.log(cat.sound())
console.log(cat.move(5));

let blackCat = Object.create(animal);

let dog = {};
Object.setPrototypeOf(dog, animal);
dog.name = "Bulldog";
console.log(dog);

let tiger = {};
tiger._proto_ = animal;
console.log(tiger);