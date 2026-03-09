function palindromeIntegers(numbers) {
    for (let num of numbers) {
        let numStr = num.toString();
        let reversedStr = numStr.split('').reverse().join('');
        if (numStr === reversedStr) {
            console.log("true");
        } else {
            console.log("false");
        }
    }
}

palindromeIntegers([123, 121, 454, 1001, 34]);