class Solution {
    int[][] grid;
    int rows;
    int cols;
    int s = 0;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        int mxs = 0;
        for(int i = 0; i<this.rows; i++){
            for(int j = 0; j<this.cols; j++){
                if(this.grid[i][j] == 1){
                    this.s = 0;
                    dfs(i,j);
                    mxs = Math.max(mxs, this.s);
                }
            }
        }
        return mxs;    
    }

    boolean dfs(int r, int c){
        if(r>=this.rows || r<0 || c<0 || c>=this.cols){
            return false;
        }
        if(this.grid[r][c] == 0){
            return false;
        }
        this.s+=1;
        this.grid[r][c] = 0;
        boolean f = dfs(r+1, c) || dfs(r-1, c) || dfs(r, c+1) || dfs(r, c-1);
        return f;
    }
}
