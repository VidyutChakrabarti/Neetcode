class Solution {
    int rows;
    int cols;
    char b[][];
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.b = board;
        for(int i = 0; i<cols; i++){
            if(b[0][i] == 'O'){
                dfs(0,i);
            }
            if(b[rows-1][i] == 'O'){
                dfs(rows-1, i);
            }
        } 
        for(int i = 0; i<rows; i++){
            if(b[i][0] == 'O'){
                dfs(i,0);
            }
            if(b[i][cols-1] == 'O'){
                dfs(i, cols-1);
            }
        }

        for(int i = 0; i< rows;i++){
            for(int j = 0; j<cols; j++){
                if(b[i][j] == '#'){
                    b[i][j] = 'O';
                }else{
                    b[i][j] = 'X';
                }
            }
        }
    }

    void dfs(int row, int col){
        b[row][col] = '#';
        for(int[] d: dirs){
            int r = row+d[0];
            int c = col+d[1];
            if(r>=0 && c>=0 && c<cols && r<rows && b[r][c]=='O'){
                dfs(r,c);
            }
        }
        return;
    }
}
