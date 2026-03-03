function stringSubstring(word, text) {
    let lowerWord = word.toLowerCase();
    let words = text.split(' ');

    for (let w of words) {
        if (w.toLowerCase() === lowerWord) {
            console.log(word);
            return;
        }
    }

    console.log(`${word} not found!`);
}