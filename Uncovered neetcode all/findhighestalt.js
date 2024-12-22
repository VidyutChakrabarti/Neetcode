/**
 * @param {number[]} gain
 * @return {number}
 */

var largestAltitude = function (gain) {
    let highestGain = 0 < gain[0] ? gain[0] : 0;

    for (let i = 0; i < gain.length - 1; i++) {
        gain[i + 1] = gain[i] + gain[i + 1];
        highestGain = highestGain < gain[i + 1] ? gain[i + 1] : highestGain;
    }

    return highestGain;
};