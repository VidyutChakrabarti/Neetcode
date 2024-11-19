class Solution {
    public int climbStairs(int n) {
        int nth = 1;
        int nth_1 = 1;
        int temp;
        
        for(int i = n-1; i>0; i--){
            temp = nth;
            nth = nth + nth_1;
            nth_1 = temp;
        }
        return nth;   
    }
}
