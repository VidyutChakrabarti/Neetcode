//Prim's Algorithm for Minimum Spanning Tree (MST)

class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> mh = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        HashMap<Integer, List<int[]>> g = new HashMap<>();

        int n = points.length; 
        
        for(int i = 0; i<n; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];

            for(int j = 0; j<n; j++){
                if(i==j) continue;
                int x2 = points[j][0], y2 = points[j][1];
                int d = Math.abs(x1-x2) + Math.abs(y1- y2);
                g.computeIfAbsent(i, l-> new ArrayList<>()).add(new int[]{d, j});
                g.computeIfAbsent(j, l-> new ArrayList<>()).add(new int[]{d, i});
             }
        }

        int mincost = 0;
        HashSet<Integer> visited = new HashSet<>();
        
        mh.offer(new int[]{0,0});

        while(visited.size() < n){
            int[] node = mh.poll();
            if(visited.contains(node[1])) continue;
            mincost+=node[0];
            visited.add(node[1]);
            for(int[] ns: g.getOrDefault(node[1], Collections.emptyList())){
                mh.offer(ns);
            }
        }
        return mincost;
    }
}
