function revealWords(wordsStr, text) {
    let words = wordsStr.split(', ');
    let textArr = text.split(' ');

    for (let i = 0; i < textArr.length; i++) {
        if (textArr[i].includes('*')) {
            let wordToReplace = words.find(w => w.length === textArr[i].length);
            if (wordToReplace) {
                textArr[i] = wordToReplace;
            }
        }
    }

    console.log(textArr.join(' '));
}