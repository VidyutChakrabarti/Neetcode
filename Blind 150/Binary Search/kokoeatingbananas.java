class Solution {
    public long time(int[] ps, int k){
        long t = 0;
        for(int p: ps){
            t+=Math.ceil((double) p/k);
        }
        return t;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        int n = piles.length;
        for(int i = 0; i<n; i++){
            r = Math.max(r, piles[i]);
        }
        // int res = r;
        while(l<=r){
            int k = (l+r) / 2;
            long tt = time(piles, k);
            if(tt<=h){
                // res = k;
                r = k-1;
            }else{
                l = k+1;
            }
        }
        return l;
    }
}
