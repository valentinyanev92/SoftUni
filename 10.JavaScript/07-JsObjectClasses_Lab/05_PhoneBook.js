function phoneBook(input) {
    let book = {};

    for (let entry of input) {
        let [name, number] = entry.split(' ');
        book[name] = number;
    }

    for (let name in book) {
        console.log(`${name} -> ${book[name]}`);
    }
}

phoneBook([
    "Tim 12345",
    "Peter 54321",
    "Tim 67890"
]);