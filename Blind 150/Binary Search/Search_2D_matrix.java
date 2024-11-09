class Solution {
    public int bins(int[][] m, int target) {
        int j = m.length;
        int k = m[0].length; 
        int l = 0; 
        int r = k*j-1;
        
        while(l<=r){
            int mid = l + (r - l) / 2; 
            int col = mid%k;
            int row = mid/k;
            if(m[row][col]<target){
                l = mid+1;
            }else if(m[row][col] == target){
                return mid;
            }else{
                r = mid-1;
            }
        }
        return -1;   
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int res = bins(matrix, target);
        System.out.println(res);
        if(res==-1){
            return false;
        }else{
            return true;
        }
    }
}
