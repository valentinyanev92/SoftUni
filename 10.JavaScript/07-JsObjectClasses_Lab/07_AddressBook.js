function addressBook(input) {
    let book = {};

    for (let entry of input) {
        let [name, address] = entry.split(':');
        book[name] = address;
    }

    let sortedNames = Object.keys(book).sort();

    for (let name of sortedNames) {
        console.log(`${name} -> ${book[name]}`);
    }
}

addressBook([
    'Tim:Doe Crossing',
    'Bill:Nelson Place',
    'Peter:Carlyle Ave',
    'Bill:Ornery Rd'
]);
addressBook([
    'Bob:Huxley Rd',
    'John:Milwaukee Crossing',
    'Peter:Fordem Ave',
    'Bob:Redwing Ave',
    'George:Mesta Crossing',
    'Ted:Gateway Way',
    'Bill:Gateway Way',
    'John:Grover Rd',
    'Peter:Huxley Rd',
    'Jeff:Gateway Way',
    'Jeff:Huxley Rd'
]);