class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int amt = 1; amt<=amount; amt++){
            for(int j = 0; j<coins.length; j++){
                if(amt-coins[j]>=0){
                dp[amt] = Math.min(dp[amt], dp[amt-coins[j]] + 1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
