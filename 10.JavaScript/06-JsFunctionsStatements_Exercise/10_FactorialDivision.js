function factorialDivision(num1, num2) {
    function factorial(n) {
        let result = 1;
        for (let i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    let fact1 = factorial(num1);
    let fact2 = factorial(num2);

    let division = fact1 / fact2;

    console.log(division.toFixed(2));
}

factorialDivision(5, 2);
factorialDivision(6, 3);