function oddOccurrences(input) {
    let words = input.toLowerCase().split(' ');
    let counts = {};

    for (let word of words) {
        counts[word] = (counts[word] || 0) + 1;
    }

    let result = [];
    for (let word of words) {
        if (counts[word] % 2 !== 0 && !result.includes(word)) {
            result.push(word);
        }
    }

    console.log(result.join(' '));
}

oddOccurrences('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
oddOccurrences('Cake IS SWEET is Soft CAKE sweet Food');