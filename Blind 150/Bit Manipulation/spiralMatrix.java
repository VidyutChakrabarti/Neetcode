//iteration optimal

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] steps = {matrix[0].length, matrix.length - 1};

        int r = 0, c = -1, d = 0;
        while (steps[d % 2] > 0) {
            for (int i = 0; i < steps[d % 2]; i++) {
                r += directions[d][0];
                c += directions[d][1];
                res.add(matrix[r][c]);
            }
            steps[d % 2]--;
            d = (d + 1) % 4;
        }
        return res;
    }
}

/*

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        // append all the elements in the given direction
        dfs(m, n, 0, -1, 0, 1, matrix, res);
        return res;
    }

    private void dfs(int row, int col, int r, int c, 
                     int dr, int dc, int[][] matrix, List<Integer> res) {
        if (row == 0 || col == 0) return;
        
        for (int i = 0; i < col; i++) {
            r += dr;
            c += dc;
            res.add(matrix[r][c]);
        }

        // sub-problem
        dfs(col, row - 1, r, c, dc, -dr, matrix, res);
    }
}

simple iteration: 

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;

        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            right--;
            if (!(left < right && top < bottom)) {
                break;
            }
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;
            for (int i = bottom - 1; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}

*/