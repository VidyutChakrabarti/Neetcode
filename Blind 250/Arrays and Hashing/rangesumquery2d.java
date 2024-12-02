//one dimensional prefix sum array

public class NumMatrix {

    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        prefixSum = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            prefixSum[row][0] = matrix[row][0];
            for (int col = 1; col < cols; col++) {
                prefixSum[row][col] = prefixSum[row][col - 1] + matrix[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int row = row1; row <= row2; row++) {
            if (col1 > 0) {
                res += prefixSum[row][col2] - prefixSum[row][col1 - 1];
            } else {
                res += prefixSum[row][col2];
            }
        }
        return res;
    }
}

