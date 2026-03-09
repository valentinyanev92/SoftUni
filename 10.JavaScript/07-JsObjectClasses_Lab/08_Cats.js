class Cat {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    meow() {
        console.log(`${this.name}, age ${this.age} says Meow`);
    }
}

function createCats(input) {
    let cats = [];

    for (let line of input) {
        let [name, age] = line.split(' ');
        age = Number(age);
        let cat = new Cat(name, age);
        cats.push(cat);
    }

    for (let cat of cats) {
        cat.meow();
    }
}

createCats(['Mellow 2', 'Tom 5']);

createCats(['Candy 1', 'Poppy 3', 'Nyx 2']);