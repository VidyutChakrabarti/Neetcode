class Solution {
    int[][] dirs = {{1,0}, {-1,0}, 
                    {0,1}, {0,-1}};
    int rows;
    int cols;
    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ArrayList<int []> pacific = new ArrayList<>();
        ArrayList<int []> atlantic = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        this.rows = rows;
        this.cols = cols;
        this.heights = heights;

        for(int i = 0; i < rows; i++){
            pacific.add(new int[]{i,0});
            atlantic.add(new int[]{i,cols - 1});
        }
        for(int i = 0; i < cols; i++){
            pacific.add(new int[]{0,i});
            atlantic.add(new int[]{rows - 1, i});
        }

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atc = new boolean[rows][cols];

        for(int [] p: pacific){
            dfs(p, pac);
        }
        for(int [] at: atlantic){
            dfs(at, atc);
        }
        List<List<Integer>> s = new ArrayList<>();
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(pac[i][j] && atc[i][j]){
                    s.add(Arrays.asList(i, j));
                }
            }
        }
        return s;
    }

void dfs(int[] p, boolean[][] ocean){
    ocean[p[0]][p[1]] = true;
        for(int v = 0; v<4; v++){
            int r = p[0] + dirs[v][0];
            int c = p[1] + dirs[v][1];
            if(r<rows && c<cols && c>=0 && r>=0 && !ocean[r][c] &&
            this.heights[r][c] >= this.heights[p[0]][p[1]]){
                dfs(new int[]{r,c}, ocean);
            }
        }
    return;
    }
}
