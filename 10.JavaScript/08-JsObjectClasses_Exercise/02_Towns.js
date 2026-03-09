function towns(input) {
    for (let line of input) {
        let [townName, lat, long] = line.split(' | ');
        let town = {
            town: townName,
            latitude: Number(lat).toFixed(2),
            longitude: Number(long).toFixed(2)
        };
        console.log(town);
    }
}

towns([
    'Sofia | 42.696552 | 23.32601',
    'Beijing | 39.913818 | 116.363625'
]);
towns([
    'Plovdiv | 136.45 | 812.575'
]);