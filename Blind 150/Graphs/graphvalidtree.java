class Solution {
    HashMap<Integer, ArrayList<Integer>> graph;
    ArrayList<Integer> emp = new ArrayList<>();

    public boolean validTree(int n, int[][] edges) {
        graph = new HashMap<>();
        for(int[] pre: edges){
            int key = pre[0];
            int value = pre[1];
            graph.computeIfAbsent(key, k -> new ArrayList<>());
            graph.get(key).add(value);
            graph.computeIfAbsent(value, k -> new ArrayList<>());
            graph.get(value).add(key);
        }

        boolean[] visited = new boolean[n];
        boolean f = dfs(0, -1,visited);
        if(!f){
            return false;
        }
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    boolean dfs(int at, int parent, boolean[] visited){
        visited[at] = true;
        ArrayList<Integer> neighbours = graph.getOrDefault(at, emp);
        for(int nr: neighbours){
            if(nr == parent){continue;}// it is undirected and hence may endup visiting the parent node even if cycle was not there.
            if(!visited[nr]){
                if(!dfs(nr, at, visited)){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
