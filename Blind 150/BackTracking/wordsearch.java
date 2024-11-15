class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0, new boolean[rows][cols])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
            || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        boolean found =
            dfs(board, i + 1, j, word, index + 1, visited) ||
            dfs(board, i - 1, j, word, index + 1, visited) ||
            dfs(board, i, j + 1, word, index + 1, visited) ||
            dfs(board, i, j - 1, word, index + 1, visited);

        visited[i][j] = false; // backtrack

        return found;
    }
}
