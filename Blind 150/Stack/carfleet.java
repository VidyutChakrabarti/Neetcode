class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i =0; i<n; i++){
            tm.put(position[i], speed[i]);
        }
        List<Double> t = new ArrayList<>();
        for (int p: tm.keySet()) {
            double time = (target - p) / (double) tm.get(p);
            t.add(time);
        }
        int ans = 1;
        double maxn = t.get(n-1);
        for(int i = n-2; i>=0;i--){
            if(t.get(i)>maxn){
                ans++;
                maxn = t.get(i);
            }
        }
        return ans;
    }
}
