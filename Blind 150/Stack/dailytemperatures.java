class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i = 0; i<n; i++){
            int t = temperatures[i];
            if(st.empty()){
                st.push(i);
            }else{
                if(temperatures[st.peek()]<t){
                    while(!st.empty()){
                        //System.out.println(st);
                        if(temperatures[st.peek()]<t){
                            int j = st.pop();
                            result[j] = i - j;
                        }else{
                            break;
                        } 
                    }
                }
                st.push(i);
            }
        }
    while(!st.empty()){
        int k = st.pop();
        result[k] = 0;
    }
    return result;
    }
}
