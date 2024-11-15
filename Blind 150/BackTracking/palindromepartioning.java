class Solution {
    int n;
    String s; 
    boolean palindrome(String w){
        int k = w.length();
        int idx = 0;
        while(idx<k/2){
            if(!(w.charAt(idx) == w.charAt(k - idx - 1))){
                return false;
            }
            idx++;
        }
        return true; 
    }
    void dfs(List<List<String>>ans, List<String> part, int i){
        if(i>=n){
            ans.add(new ArrayList<>(part));
            return;
        }
        for(int j=i;j<n;j++){
            String sbs = s.substring(i, j+1);
            if(palindrome(sbs)){
                part.add(sbs);
                dfs(ans, part, j+1);
                part.remove(part.size() -1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        this.s = s;  
        List<List<String>> ans= new ArrayList<>();
        List<String> part = new ArrayList<>();
        n = s.length();
        dfs(ans, part, 0);
        return ans;
    }
}
