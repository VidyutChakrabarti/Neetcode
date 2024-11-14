class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<ArrayList<Object>> pq = new PriorityQueue<>(
            (a, b) -> Double.compare((double) a.get(1), (double) b.get(1))
        );

        for (int[] p : points) {
            double d = Math.sqrt(Math.pow(p[0], 2) + Math.pow(p[1], 2));
            ArrayList<Object> r = new ArrayList<>();
            r.add(p); 
            r.add(d);
            pq.offer(r);
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = (int[]) pq.poll().get(0);
        }

        return ans;
    }
}
