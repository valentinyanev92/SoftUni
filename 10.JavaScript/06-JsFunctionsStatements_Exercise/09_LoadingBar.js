function loadingBar(number) {
    let percent = number / 10;
    let bar = '%'.repeat(percent) + '.'.repeat(10 - percent);

    if (number === 100) {
        console.log("100% Complete!");
        console.log(`[${bar}]`);
    } else {
        console.log(`${number}% [${bar}]`);
        console.log("Still loading...");
    }
}

loadingBar(30);
loadingBar(100);