//bellman ford


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dists = new int[n];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[src] = 0;
        for(int i=0; i<k+1;i++){
            int[] ds = Arrays.copyOf(dists, n);
            for(int[] f: flights){
                int s = f[0];
                int d = f[1];
                int p = f[2];
                if(dists[s] == Integer.MAX_VALUE) continue;

                if(dists[s]+p < ds[d]){
                    ds[d] = dists[s]+p;
                }
            }
            dists = ds;
        }

        if(dists[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dists[dst];
    }
}
