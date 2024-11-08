class Solution {
    public int maxProfit(int[] prices) {
        int minm = prices[0];
        int n = prices.length;
        if(n==1){
            return 0;
        }
        int max_profit = Math.max(prices[1] - minm,0);

        for(int i = 2; i<n; i++){
            minm = Math.min(minm, prices[i-1]);
            max_profit = Math.max(max_profit, prices[i] - minm);
        }
        return max_profit;
    }
}
