class Goat extends Animal{
    Constructor(name, gender) {
        super.Constructor(name, gender);
        this.name = name;
        this.gender = gender;
    }

    getGender(){
       return this.name;
    }
    shout(){
        return `Meh!`;
    }

}