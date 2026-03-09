function employees(input) {
    let employeeList = {};

    for (let name of input) {
        employeeList[name] = name.length;
    }

    for (let name in employeeList) {
        console.log(`Name: ${name} -- Personal Number: ${employeeList[name]}`);
    }
}

employees([
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal'
]);
employees([
    'Samuel Jackson',
    'Will Smith',
    'Bruce Willis',
    'Tom Holland'
]);