class Solution {
    public boolean isValid(String s) {
      Stack<Character> st = new Stack<>();
      Set<Character> op = new HashSet<>(Arrays.asList('[', '{', '('));
      int n = s.length();
      for(int i = 0; i<n ; i++){
        char c = s.charAt(i);
        if(op.contains(c)){
            st.push(c);
        }
        else{
            if(c==']'){
                if(st.empty() || st.peek()!='['){
                    return false;
                }else{
                    char j = st.pop();
                }
            }else if(c=='}'){
                if(st.empty() || st.peek()!='{'){
                    return false;
                }else{
                    char j = st.pop();
                }
            }else{
                if(st.empty() || st.peek()!='('){
                    return false;
                }else{
                    char j = st.pop();
                }
            }
        }
      }
      if(st.empty()){
        return true;
      }
      return false;
    }
}
