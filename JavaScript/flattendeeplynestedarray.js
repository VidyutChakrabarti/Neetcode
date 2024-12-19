/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    if (n === 0) {
        return arr;
    }
    let values = [];
    for (let i = 0; i < arr.length; i++) {
        if (n > 0 && Array.isArray(arr[i])) {
            values.push(...flat(arr[i], n - 1));
        }
        else {
            values.push(arr[i]);
        }
    }
    return values;
};
