function orders(order, quantity) {
    
    let orderSinglePrice = 1;

    switch(order) {
        case 'coffee' :{
            orderSinglePrice = 1.5;
            break;
        }
        case 'water' :{
            orderSinglePrice = 1;
            break;
        }
        case 'coke' :{
            orderSinglePrice = 1.4;
            break;
        }
        case 'snacks' :{
            orderSinglePrice = 2;
            break;
        }        
    }
    
    console.log((quantity * orderSinglePrice).toFixed(2));
}

orders('water', 5);
orders('coffee', 2);
orders('coke', 2);