function result(arr) {
    
    const sorted = arr.sort((a, b) => a - b);
    
    const result = [];
    let left = 0;
    let right = sorted.length - 1;
    
    while (left <= right) {
        if (left === right) {
            result.push(sorted[left]);
        } else {
            result.push(sorted[left]);
            result.push(sorted[right]);
        }
        left++;
        right--;
    }
    
    return result;
}

console.log(result([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));