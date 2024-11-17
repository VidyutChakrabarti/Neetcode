class Solution {
    HashMap<Integer, ArrayList<Integer>> graph;
    ArrayList<Integer> emp = new ArrayList<>();

    public int countComponents(int n, int[][] edges) {
        graph = new HashMap<>();
        for(int[] pre: edges){
            int key = pre[0];
            int value = pre[1];
            graph.computeIfAbsent(key, k -> new ArrayList<>());
            graph.get(key).add(value);
            graph.computeIfAbsent(value, k -> new ArrayList<>());
            graph.get(value).add(key);
        }

        int s = 0;

        boolean[] visited = new boolean[n];
        //boolean[] onPath = new boolean[n];
        //onPath isn't required as there can be multiple cycles in a connected component.

        for(int i = 0; i<n; i++){
            if(!visited[i]){
                dfs(i,-1, visited);
                s+=1;
            }
        }
        return s;
    }

    void dfs(int at, int parent, boolean[] visited){
        visited[at] = true;
        ArrayList<Integer> neighbours = graph.getOrDefault(at, emp);
        for(int to: neighbours){
            if(to == parent){continue;}
            if(!visited[to]){
                dfs(to,at,visited);
            }
        }
        return;
        }
    }

