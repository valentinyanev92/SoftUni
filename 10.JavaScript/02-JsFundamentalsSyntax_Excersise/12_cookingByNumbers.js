function cookingByNumbers(...params) {

    let num = Number(params[0]);

    let operations = params.slice(1);

    function applyOperation(number, operation) {
        switch (operation) {
            case 'chop': 
                return number / 2;
            case 'dice': 
                return Math.sqrt(number);
            case 'spice': 
                return number + 1;
            case 'bake': 
                return number * 3;
            case 'fillet': 
                return number * 0.8;
            default: 
                return number;
        }
    }

    for (let op of operations) {
        num = applyOperation(num, op);
        console.log(num);
    }
}