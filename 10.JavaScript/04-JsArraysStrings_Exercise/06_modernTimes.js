function modernTimes(text) {
    let words = text.split(' ');

    for (let word of words) {
        if (word.startsWith('#')) {
            let tag = word.slice(1); // махаме #
            if (/^[A-Za-z]+$/.test(tag)) { // само букви
                console.log(tag);
            }
        }
    }
}