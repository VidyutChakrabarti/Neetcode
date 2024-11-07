class Solution {
    public int trap(int[] height) {
    int n = height.length;
    if(n==1){
        return 0;
    }
    int ans = 0;
    int[] pre = new int[n];
    int[] suff = new int[n];
    int maxp = 0;
    int maxs = 0; 
    for(int i = 0; i<n; i++){
        maxp = Math.max(maxp, height[i]);
        maxs = Math.max(maxs, height[n-i-1]);
        pre[i] = maxp;
        suff[n-i-1] = maxs;
       } 

    for(int i = 0; i<n; i++){
        ans += Math.max(Math.min(pre[i], suff[i]) - height[i] ,0);
       } 
    return ans;
    }
}
