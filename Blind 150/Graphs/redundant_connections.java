class Solution {
    HashMap<Integer, ArrayList<Integer>> graph;

    public int[] findRedundantConnection(int[][] edges) {
        graph = new HashMap<>();
        for(int[] pre: edges){
            int key = pre[0] ;
            int value = pre[1];

            graph.computeIfAbsent(key, k -> new ArrayList<>());
            graph.get(key).add(value);
            graph.computeIfAbsent(value, k -> new ArrayList<>());
            graph.get(value).add(key);

            boolean[] visited = new boolean[edges.length+1];


        if (dfs(key, -1, visited)) {
                return pre;
            }
        }
        return new int[0];
    }

    private boolean dfs(int node, int parent, boolean[] visit) {
        if (visit[node]) {
            return true;
        }

        visit[node] = true;
        for (int nei : graph.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (dfs(nei, node, visit)) {
                return true;
            }
        }
        return false;
    }
    }