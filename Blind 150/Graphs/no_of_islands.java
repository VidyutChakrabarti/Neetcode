/*
 Number of Islands
Solved 
Given a 2D grid grid where '1' represents land and '0' represents water, count and return the number of islands.

An island is formed by connecting adjacent lands horizontally or vertically and is surrounded by water. You may assume water is surrounding the grid (i.e., all the edges are water).

Example 1:

Input: grid = [
    ["0","1","1","1","0"],
    ["0","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
  ]
Output: 1
Example 2:

Input: grid = [
    ["1","1","0","0","1"],
    ["1","1","0","0","1"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
  ]
Output: 4
Constraints:

1 <= grid.length, grid[i].length <= 100
grid[i][j] is '0' or '1'.


 */

class Solution {
    char[][] grid;
    int rows;
    int cols;

    boolean dfs(int r, int c){
        if(r>=this.rows || r<0 || c<0 || c>=this.cols){
            return false;
        }
        if(this.grid[r][c] == '0'){
            return false;
        }

        this.grid[r][c] = '0';
        boolean f = dfs(r+1, c) || dfs(r-1, c) || dfs(r, c+1) || dfs(r, c-1);
        return f;
    }
    void print(){
        for(int i = 0; i<this.rows; i++){
            for(int j = 0; j<this.cols; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
System.out.println();
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        int s = 0;
        for(int i = 0; i<this.rows; i++){
            for(int j = 0; j<this.cols; j++){
                if(this.grid[i][j] == '1'){
                    dfs(i,j);
                    //print();
                    s+=1;
                }
            }
        }
        return s;
    }
}
