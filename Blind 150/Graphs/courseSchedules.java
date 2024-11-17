class Solution {
    ArrayList<Integer> emp = new ArrayList<>();
    HashMap<Integer, ArrayList<Integer>> m;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        m = new HashMap<>();
        for(int[] pre: prerequisites){
            int key = pre[0];
            int value = pre[1];
            m.computeIfAbsent(key, k->new ArrayList<>());
            m.get(key).add(value);
        }
        HashSet<Integer> path = new HashSet<>();
        for (int c = 0; c < numCourses; c++){
            boolean f = dfs(c, path);
            if(!f){
                System.out.println(path);
                return false;
            }
        }
        return true;
    }

    boolean dfs(int c, HashSet<Integer> path){
        ArrayList<Integer> tt = m.getOrDefault(c, emp);
        path.add(c);

        for(int preq: tt){
            if(path.contains(preq)){
                return false;
            }else{
                if(!dfs(preq, path)){
                    return false;
                }
            }
        }

        path.remove(c);
        m.put(c, new ArrayList<>());
        return true;
    }
}
