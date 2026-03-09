function cityInfo(city) {
    for (let key in city) {
        console.log(`${key} -> ${city[key]}`);
    }
}

cityInfo({
    name: "Sofia",
    area: 492,
    population: 1230000,
    country: "Bulgaria",
    postcode: "1000"
});