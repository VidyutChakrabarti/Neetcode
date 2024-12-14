// topological sort bfs

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] edge_cnt = new int[n];
        Queue<Integer> leaves = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            edge_cnt[i] = adj[i].size();
            if (adj[i].size() == 1)
                leaves.offer(i);
        }

        while (!leaves.isEmpty()) {
            if (n <= 2) return new ArrayList<>(leaves);
            int size = leaves.size();
            for (int i = 0; i < size; ++i) {
                int node = leaves.poll();
                n--;
                for (int nei : adj[node]) {
                    edge_cnt[nei]--;
                    if (edge_cnt[nei] == 1)
                        leaves.offer(nei);
                }
            }
        }

        return new ArrayList<>();
    }
}

