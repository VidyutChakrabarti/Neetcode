//DP_BOTTOM UP

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int n = intervals.length;
        int[] dp = new int[n];  

        for (int i = 0; i < n; i++) {
            dp[i] = 1;  
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {  
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int maxNonOverlapping = Arrays.stream(dp).max().getAsInt();  
        return n - maxNonOverlapping;
    }
}

/*

BINARY SEARCH

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int n = intervals.length;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int idx = bs(i, intervals[i][0], intervals);
            if (idx == 0) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 1], 1 + dp[idx - 1]);
            }
        }
        return n - dp[n - 1];
    }

    private int bs(int r, int target, int[][] intervals) {
        int l = 0;
        while (l < r) {
            int m = (l + r) >> 1;
            if (intervals[m][1] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}

greedy

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        int prevEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= prevEnd) {
                prevEnd = end;
            } else {
                res++;
                prevEnd = Math.min(end, prevEnd);
            }
        }
        return res;
    }
}

top down dp: 

public class Solution {
    private int[] memo;

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int n = intervals.length;
        memo = new int[n];  
        Arrays.fill(memo, -1);
        
        int maxNonOverlapping = dfs(intervals, 0);
        return n - maxNonOverlapping;
    }

    private int dfs(int[][] intervals, int i) {
        if (i >= intervals.length) return 0;
        if (memo[i] != -1) return memo[i];

        int res = 1;
        for (int j = i + 1; j < intervals.length; j++) {
            if (intervals[i][1] <= intervals[j][0]) {
                res = Math.max(res, 1 + dfs(intervals, j));
            }
        }
        memo[i] = res;
        return res;
    }
}
*/