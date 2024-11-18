//binary search + DFS

public class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        int minH = grid[0][0], maxH = grid[0][0];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                maxH = Math.max(maxH, grid[row][col]);
                minH = Math.min(minH, grid[row][col]);
            }
        }

        int l = minH, r = maxH;
        while (l < r) {
            int m = (l + r) >> 1;
            if (dfs(grid, visit, 0, 0, m)) {
                r = m;
            } else {
                l = m + 1;
            }
            for (int row = 0; row < n; row++) {
                Arrays.fill(visit[row], false);
            }
        }
        return r;
    }

    private boolean dfs(int[][] grid, boolean[][] visit, int r, int c, int t) {
        if (r < 0 || c < 0 || r >= grid.length || 
            c >= grid.length || visit[r][c] || grid[r][c] > t) {
            return false;
        }
        if (r == grid.length - 1 && c == grid.length - 1) {
            return true;
        }
        visit[r][c] = true;
        return dfs(grid, visit, r + 1, c, t) || 
               dfs(grid, visit, r - 1, c, t) || 
               dfs(grid, visit, r, c + 1, t) || 
               dfs(grid, visit, r, c - 1, t);
    }
}