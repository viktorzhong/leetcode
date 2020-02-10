class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int profit = 0, buy = prices[0];

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < buy) buy = prices[i];
            else profit = Math.max(profit, prices[i] - buy);
        }

        return profit;
    }
}