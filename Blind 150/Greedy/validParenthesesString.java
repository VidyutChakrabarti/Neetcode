//bottom up, dynamic programming solution

public class Solution {
    public boolean checkValidString(String s) {
        
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[n][0] = true;

        for (int i = n - 1; i >= 0; i--) {

            for (int open = 0; open < n; open++) {

                boolean res = false;

                if (s.charAt(i) == '*') {

                    res |= dp[i + 1][open + 1];
                    if (open > 0) res |= dp[i + 1][open - 1];
                    res |= dp[i + 1][open];

                } else {

                    if (s.charAt(i) == '(') {
                        res |= dp[i + 1][open + 1];
                    } 
                    
                    else if (open > 0) {
                        res |= dp[i + 1][open - 1];
                    }

                }

                dp[i][open] = res;

            }
        }
        return dp[0][0];
    }
}


/*

TOP DOWN

public class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] memo = new Boolean[n + 1][n + 1];
        return dfs(0, 0, s, memo);
    }

    private boolean dfs(int i, int open, String s, Boolean[][] memo) {
        if (open < 0) return false;
        if (i == s.length()) return open == 0;

        if (memo[i][open] != null) return memo[i][open];

        boolean result;
        if (s.charAt(i) == '(') {
            result = dfs(i + 1, open + 1, s, memo);
        } else if (s.charAt(i) == ')') {
            result = dfs(i + 1, open - 1, s, memo);
        } else {
            result = (dfs(i + 1, open, s, memo) || 
                      dfs(i + 1, open + 1, s, memo) || 
                      dfs(i + 1, open - 1, s, memo));
        }
        
        memo[i][open] = result;
        return result;
    }
}


RECURSION: 

public class Solution {
    public boolean checkValidString(String s) {
        
        return dfs(0, 0, s);
    }

    private boolean dfs(int i, int open, String s) {
        if (open < 0) return false;
        if (i == s.length()) return open == 0;

        if (s.charAt(i) == '(') {
            return dfs(i + 1, open + 1, s);
        } else if (s.charAt(i) == ')') {
            return dfs(i + 1, open - 1, s);
        } else {
            return dfs(i + 1, open, s) ||
                   dfs(i + 1, open + 1, s) ||
                   dfs(i + 1, open - 1, s);
        }
    }
}


SPACE OPTIMIZED

public class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = n - 1; i >= 0; i--) {
            boolean[] newDp = new boolean[n + 1];
            for (int open = 0; open < n; open++) {
                if (s.charAt(i) == '*') {
                    newDp[open] = dp[open + 1] || 
                                  (open > 0 && dp[open - 1]) || dp[open];
                } else if (s.charAt(i) == '(') {
                    newDp[open] = dp[open + 1];
                } else if (open > 0) {
                    newDp[open] = dp[open - 1];
                }
            }
            dp = newDp;
        }
        return dp[0];
    }
}


GREEDY:

public class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }
}


*/