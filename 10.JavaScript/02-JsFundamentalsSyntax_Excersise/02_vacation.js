function vacantion(groupSize, type, day) {

    let pricePerDay = 0;
    let totalPrice = 0;
    switch (type) {
        case `Students`:

            if (day == `Friday`) {
                pricePerDay = 8.45;
            } else if (day == `Saturday`) {
                pricePerDay = 9.80;
            } else {
                pricePerDay = 10.46;
            }

            totalPrice = groupSize * pricePerDay;

            if (groupSize >= 30) {
                let discount = totalPrice * 0.15;
                totalPrice -= discount;
            }
            break;
        case `Business`:

            if (day == `Friday`) {
                pricePerDay = 10.9;
            } else if (day == `Saturday`) {
                pricePerDay = 15.6;
            } else {
                pricePerDay = 16;
            }

            if (groupSize >= 100) {
                groupSize -= 10;
            }
            totalPrice = groupSize * pricePerDay;
            break;
        case `Regular`:

            if (day == `Friday`) {
                pricePerDay = 15;
            } else if (day == `Saturday`) {
                pricePerDay = 20;
            } else {
                pricePerDay = 22.5;
            }
            totalPrice = groupSize * pricePerDay;

            if (groupSize >= 10 && groupSize <= 20) {
                let discount = totalPrice * 0.05;
                totalPrice -= discount;
            }
            break;
        default:
            break;
    }

    console.log(`Total price: ${totalPrice.toFixed(2)}`);
}
