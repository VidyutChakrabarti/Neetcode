class Solution {
    int n;
    String g;
    public List<List<String>> solveNQueens(int n) {
        this.g = ".".repeat(n);
        this.n = n;
        List<int []> path = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, path, 0);
        return ans;
    }

    boolean valid(List<int[]> path, int r, int c){
    for (int[] q : path) {
        int qr = q[0], qc = q[1];
        if (qc == c || Math.abs(qr - r) == Math.abs(qc - c)) {
            return false;
        }
    }
    return true;
}

    void dfs(List<List<String>>ans, List<int[]> path, int r){
        if(path.size() == n){
            List<String>a = new ArrayList<>();
            for(int [] arr: new ArrayList<>(path)){
                int co = arr[1];
                StringBuilder sb = new StringBuilder(g);
                sb.setCharAt(co, 'Q');
                String tba = sb.toString();
                a.add(tba);
            }
            ans.add(a);
            return;
        }

        for(int j = 0; j<n; j++){
            if(valid(path, r, j)){
            path.add(new int[] {r, j});
            dfs(ans, path, r+1);
            path.remove(path.size() -1);
            }
        }
    }
}
