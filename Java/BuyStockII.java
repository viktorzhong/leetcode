class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if(prices == null || prices.length < 2) return 0;

        int low = prices[0], high = prices[0];
        int i = 0;
        while(i < prices.length - 1) {
            while(i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            low = prices[i];
            while(i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
            high = prices[i];
            profit += high - low;
        }
        return profit;
    }
}