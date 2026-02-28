function vacation(groupSize, type, day) {

    let pricePerDay = 0;
    switch (type) {
        case 'Students':
            pricePerDay = getPricePerDayStudent(day);
            break;
        case 'Business':
            pricePerDay = getPricePerDayBusiness(day);
            break;
        case 'Regular':
            pricePerDay = getPricePerDayRegular(day);
            break;
    }

    let adjustedGroupSize = groupSize;
    if (type === 'Business' && groupSize >= 100) {
        adjustedGroupSize -= 10;
    }

    let discount = getDiscount(type, groupSize);
    let totalPrice = adjustedGroupSize * pricePerDay * discount;

    console.log(`Total price: ${totalPrice.toFixed(2)}`);


    function getPricePerDayStudent(day) {
        switch (day) {
            case 'Friday': return 8.45;
            case 'Saturday': return 9.80;
            case 'Sunday': return 10.46;
        }
    }

    function getPricePerDayBusiness(day) {
        switch (day) {
            case 'Friday': return 10.90;
            case 'Saturday': return 15.60;
            case 'Sunday': return 16.00;
        }
    }

    function getPricePerDayRegular(day) {
        switch (day) {
            case 'Friday': return 15.00;
            case 'Saturday': return 20.00;
            case 'Sunday': return 22.50;
        }
    }

    function getDiscount(groupType, groupSize) {
        switch (groupType) {
            case 'Students':
                if (groupSize >= 30) return 0.85; // 15% off
                break;
            case 'Regular':
                if (groupSize >= 10 && groupSize <= 20) return 0.95; // 5% off
                break;
            default:
                return 1;
        }
        return 1;
    }
}
