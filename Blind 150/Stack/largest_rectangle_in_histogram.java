class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] ls = new int[n];
        int[] rs = new int[n];

        for(int i = 0; i<n; i++){
            ls[i] = -1;
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ls[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for(int i = n-1; i>=0; i--){
            rs[i] = n;
            
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                rs[i] = st.peek();
            }
            st.push(i); 
        }

        int maxa = 0;
        for(int i = 0; i<n; i++){
            ls[i]+=1;
            rs[i]-=1;
            maxa = Math.max(maxa, heights[i]*(rs[i] - ls[i] + 1));    
        } 

        return maxa;
    }
}
