public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][0];
    }
}


/*
TOP DOWN


public class Solution {
    private int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dfs(text1, text2, i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(dfs(text1, text2, i + 1, j), 
                                  dfs(text1, text2, i, j + 1));
        }
        return memo[i][j];
    }
}


RECURSIVE

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + dfs(text1, text2, i + 1, j + 1);
        }
        return Math.max(dfs(text1, text2, i + 1, j),
                        dfs(text1, text2, i, j + 1));
    }
}
*/