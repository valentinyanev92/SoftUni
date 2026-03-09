function meetings(input) {
    let schedule = {};

    for (let entry of input) {
        let [day, person] = entry.split(' ');

        if (!schedule.hasOwnProperty(day)) {
            schedule[day] = person;
            console.log(`Scheduled for ${day}`);
        } else {
            console.log(`Conflict on ${day}!`);
        }
    }

    for (let day in schedule) {
        console.log(`${day} -> ${schedule[day]}`);
    }
}

meetings(['Monday Peter',
          'Wednesday Bill',
          'Monday Tim',
          'Friday Tim']);