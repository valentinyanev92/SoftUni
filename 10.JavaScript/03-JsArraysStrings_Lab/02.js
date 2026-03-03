function reverseArrayOfNumbers(arrayLength, array) {

    let newArray = [];
    for (let i = 0; i < arrayLength; i++) {
        newArray.push(array[i]);
    }
    
    let output="";
    for (let i = newArray.length - 1; i >= 0; i--) {
        output += newArray[i];
        if (i != 0 ){
            output += " ";
        }
    }

    console.log(output);
}

reverseArrayOfNumbers(3, [10, 20, 30, 40, 50]);
reverseArrayOfNumbers(4, [-1, 20, 99, 5]);
reverseArrayOfNumbers(2, [66, 43, 75, 89, 47]);