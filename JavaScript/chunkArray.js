/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
const chunk = (arr, size) => {
    return arr.reduce((chunkedArray, element) => {
        const lastChunk = chunkedArray[chunkedArray.length - 1];
        if (!lastChunk || lastChunk.length === size) {
            chunkedArray.push([element]);
        } else {
            lastChunk.push(element);
        }
        return chunkedArray;
    }, []);
};
