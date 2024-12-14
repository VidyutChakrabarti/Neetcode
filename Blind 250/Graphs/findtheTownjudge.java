// indegree and outdegree

public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] delta = new int[n + 1];

        for (int[] t : trust) {
            delta[t[0]] -= 1;
            delta[t[1]] += 1;
        }
        
        for (int i = 1; i <= n; i++) {
            if (delta[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}
