function oddAndEvenSum(number) {
    let numStr = number.toString();
    let evenSum = 0;
    let oddSum = 0;

    for (let char of numStr) {
        let digit = Number(char);
        if (digit % 2 === 0) {
            evenSum += digit;
        } else {
            oddSum += digit;
        }
    }

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
}

oddAndEvenSum(3495892137259234);