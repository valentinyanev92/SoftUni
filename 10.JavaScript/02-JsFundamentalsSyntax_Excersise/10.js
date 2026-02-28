function sameNumbers(number) {

    let numStr = number.toString();
    let sum = 0;
    let allSame = true;
    let firstDigit = numStr[0];

    for (let i = 0; i < numStr.length; i++) {
        sum += Number(numStr[i]);
        if (numStr[i] !== firstDigit) {
            allSame = false;
        }
    }

    console.log(allSame);
    console.log(sum);
}