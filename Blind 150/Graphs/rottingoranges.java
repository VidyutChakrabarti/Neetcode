class Solution {
    int[][] dirs = {{1, 0}, {-1, 0},
                     {0,1}, {0,-1}};

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>(); 
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                    grid[i][j] = 0;
                }
                else if(grid[i][j] == 0){
                    grid[i][j] = -1;
                }
                else{
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!q.isEmpty()){
            int [] p = q.poll();
            int row = p[0];
            int col = p[1];
            for(int i = 0; i<4; i++){
                int[] d = dirs[i];
                int r = row + d[0];
                int c = col + d[1];
                if(r<0 || c<0 || r>=rows || c>=cols || grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }
                grid[r][c] = grid[row][col]+1;
                q.add(new int[]{r,c});
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(ans<grid[i][j]){
                    ans = grid[i][j];
                    System.out.println(ans +" "+ grid[i][j]);
                }
            }
        }
        if(ans == Integer.MAX_VALUE){
            return -1;
        }else{
            return Math.max(0,ans);
        }

    }
}
