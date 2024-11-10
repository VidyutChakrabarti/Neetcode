class Solution {
    public void backtrack(int o, int c, int n, List<String> res, StringBuilder st){
        if(o==c && o==n){
            res.add(st.toString());
            return;
        }
        if(o<n){
            st.append('(');
            backtrack(o+1, c, n, res, st);
            st.deleteCharAt(st.length()-1);
        }
        if(c<o){
            st.append(')');
            backtrack(o, c+1, n, res, st);
            st.deleteCharAt(st.length()-1);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>(); 
        StringBuilder s = new StringBuilder("");
        backtrack(0,0,n,res,s);
        return res;
    }
}
