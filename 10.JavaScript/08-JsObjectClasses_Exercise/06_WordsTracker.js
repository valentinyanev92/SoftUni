function wordsTracker(input) {
    let wordsToCheck = input[0].split(' ');
    let wordCount = {};

    for (let word of wordsToCheck) {
        wordCount[word] = 0;
    }

    for (let i = 1; i < input.length; i++) {
        let word = input[i];
        if (wordCount.hasOwnProperty(word)) {
            wordCount[word]++;
        }
    }

    let sorted = Object.entries(wordCount).sort((a, b) => b[1] - a[1]);

    for (let [word, count] of sorted) {
        console.log(`${word} - ${count}`);
    }
}

wordsTracker([
    'this sentence', 
    'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the', 'occurrences', 'of', 'the', 'words', 'this', 'and', 'sentence', 'because', 'this', 'is', 'your', 'task'
]);
wordsTracker([
    'is the', 
    'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence'
]);