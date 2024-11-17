class Solution {
    HashMap<Integer, ArrayList<Integer>> m;
    ArrayList<Integer> emp = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        m = new HashMap<>();
        for(int[] pre: prerequisites){
            int key = pre[0];
            int value = pre[1];
            m.computeIfAbsent(key, k -> new ArrayList<>());
            m.get(key).add(value);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        int[] ordering = new int[numCourses];
        int[] index = new int[]{0};  // use array to mutate inside dfs

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                
                if(!dfs(i, visited, onPath, ordering, index)){
                    return new int[0];  // cycle detected
                }
            }
        }

        return ordering;
    }

    boolean dfs(int at, boolean[] visited, boolean[] onPath, int[] ordering, int[] index){
        visited[at] = true;
        onPath[at] = true;

        for(int to : m.getOrDefault(at, emp)){
            if(!visited[to]){
                if(!dfs(to, visited, onPath, ordering, index)){
                    return false;
                }
            } else if(onPath[to]){
                return false;  // cycle detected
            }
        }

        onPath[at] = false;
        ordering[index[0]++] = at;
        return true;
    }
}
