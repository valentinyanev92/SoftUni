function movies(input) {
    let moviesArr = [];

    for (let line of input) {
        if (line.startsWith('addMovie ')) {
            let name = line.slice(9);
            moviesArr.push({ name });
        } else if (line.includes(' directedBy ')) {
            let [movieName, director] = line.split(' directedBy ');
            let movie = moviesArr.find(m => m.name === movieName);
            if (movie) {
                movie.director = director;
            }
        } else if (line.includes(' onDate ')) {
            let [movieName, date] = line.split(' onDate ');
            let movie = moviesArr.find(m => m.name === movieName);
            if (movie) {
                movie.date = date;
            }
        }
    }

    for (let movie of moviesArr) {
        if (movie.name && movie.director && movie.date) {
            console.log(JSON.stringify(movie));
        }
    }
}

movies([
    'addMovie Fast and Furious',
    'addMovie Godfather',
    'Inception directedBy Christopher Nolan',
    'Godfather directedBy Francis Ford Coppola',
    'Godfather onDate 29.07.2018',
    'Fast and Furious onDate 30.07.2018',
    'Batman onDate 01.08.2018',
    'Fast and Furious directedBy Rob Cohen'
]);