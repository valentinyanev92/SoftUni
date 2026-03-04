function pascalSplitter(text) {
    let words = text.split(/(?=[A-Z])/);
    console.log(words.join(', '));
}