function censoredWords(text, word) {
    let stars = '*'.repeat(word.length);
    let regex = new RegExp(word, 'g');
    console.log(text.replace(regex, stars));
}

censoredWords('A small sentence with some words', 'small');
censoredWords('Find the hidden word', 'hidden');