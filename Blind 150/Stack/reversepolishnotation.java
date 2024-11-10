class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Set<String> op = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            String c = tokens[i];
            if(op.contains(c)){
                int sec = st.pop(); 
                int f = st.pop();
                if(c .equals("+")){
                    int res = f+sec;
                    st.push(res);
                }else if(c.equals("*")){
                    int res = f*sec;
                    st.push(res);
                }else if(c.equals("-")){
                    int res = f-sec;
                    st.push(f-sec);
                }else{
                    int res = f/sec;
                    st.push(f/sec);
                }
            }else{
                int l = Integer.parseInt(c);
                st.push(l);
            }
        }
        int tbe = st.pop();
        // System.out.println(tbe);
        return tbe; 
    }
}
