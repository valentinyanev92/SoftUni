function calculate (numOne, numTwo, operator) {
    let result;

    switch (operator) {
        case 'multiply':
            result = numOne * numTwo;
            break;
        case 'divide':
            result = numOne / numTwo;
            break;
        case 'add':
            result = numOne + numTwo;
            break;
        case 'subtract':
            result = numOne - numTwo;
            break;
        default:
            result = 'Invalid operator';
    }

    return result;
};

console.log(calculate(5, 5, 'multiply'));
console.log(calculate(40, 8, 'divide'));
console.log(calculate(12, 19, 'add'));
console.log(calculate(50, 13, 'subtract'));