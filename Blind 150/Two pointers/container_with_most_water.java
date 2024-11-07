class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0;
        int r = n-1;
        int maxa = (r-l)*Math.min(heights[l], heights[r]); 
        while(l<r){
            if(heights[l]<heights[r]){
                int curra = (r-l)*heights[l];
                maxa = Math.max(curra, maxa);
                l++;
            }
            else{
                int curra = (r-l)*heights[r];
                maxa = Math.max(curra, maxa);
                r--;
            }
        }
        return maxa;
    }
}
