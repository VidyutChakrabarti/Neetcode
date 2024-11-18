//Djikstra's Algorithm for Network Delay Time

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> hm = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0] - b[0])
        );

        if (n == 1) {
            return 0;
        }

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];
            hm.computeIfAbsent(u, m -> new ArrayList<>()).add(new int[]{w, u, v});
        }

        int[] visited = new int[n];
        visited[k - 1] = 1;
        int cov = 1;

        for (int[] edge : hm.getOrDefault(k - 1, Collections.emptyList())) {
            pq.offer(new int[]{edge[0], edge[1], edge[2]}); // clone edge
        }

        HashMap<Integer, Integer> mind = new HashMap<>();
        mind.put(k - 1, 0);

        while (cov < n && !pq.isEmpty()) {
            int[] edge = pq.poll();

            if (visited[edge[2]] == 1) continue;

            mind.put(edge[2], edge[0]);
            visited[edge[2]] = 1;
            cov += 1;

            for (int[] e : hm.getOrDefault(edge[2], Collections.emptyList())) {
                if (visited[e[2]] != 1) {
                    pq.offer(new int[]{e[0] + edge[0], e[1], e[2]});
                }
            }
        }

        if (cov < n) {
            return -1;
        }

        return Collections.max(mind.values());
    }
}
