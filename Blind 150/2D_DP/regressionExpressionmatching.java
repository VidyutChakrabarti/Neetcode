class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;

        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean match = i < m && (s.charAt(i) == p.charAt(j) ||
                                          p.charAt(j) == '.');

                if ((j + 1) < n && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2];
                    if (match) {
                        dp[i][j] = dp[i + 1][j] || dp[i][j];
                    }
                } else if (match) {
                    dp[i][j] = dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}


/*
SPACE OPTIMIZED

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[] dp = new boolean[p.length() + 1];
        dp[p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            boolean[] nextDp = new boolean[p.length() + 1];
            nextDp[p.length()] = (i == s.length());

            for (int j = p.length() - 1; j >= 0; j--) {
                boolean match = i < s.length() && 
                                (s.charAt(i) == p.charAt(j) || 
                                 p.charAt(j) == '.');

                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    nextDp[j] = nextDp[j + 2];
                    if (match) {
                        nextDp[j] |= dp[j];
                    }
                } else if (match) {
                    nextDp[j] = dp[j + 1];
                }
            }

            dp = nextDp;
        }

        return dp[0];
    }
}

OPTIMAL

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[] dp = new boolean[p.length() + 1];
        dp[p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            boolean dp1 = dp[p.length()];
            dp[p.length()] = (i == s.length());

            for (int j = p.length() - 1; j >= 0; j--) {
                boolean match = i < s.length() && 
                                (s.charAt(i) == p.charAt(j) || 
                                 p.charAt(j) == '.');
                boolean res = false;
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    res = dp[j + 2];
                    if (match) {
                        res |= dp[j];
                    }
                } else if (match) {
                    res = dp1;
                }
                dp1 = dp[j];
                dp[j] = res;
            }
        }

        return dp[0];
    }
}


*/