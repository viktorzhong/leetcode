class Solution {
    private int MAX_VALUE = 1000000;
    private static int f[][];
    
    private int solve(int[] coins, int amount, int idx) {
        if(amount < 0 || idx >= coins.length) return MAX_VALUE;
        if(amount == 0) return 0;

        if(f[idx][amount] >= 0) return f[idx][amount];
        int res = Math.min(solve(coins, amount - coins[idx], idx) + 1,
              solve(coins, amount, idx + 1));
        f[idx][amount] = res;
        return res;
    }

    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) return -1;

        f = new int[coins.length + 1][amount + 1];
        for(int[] row : f) Arrays.fill(row, -1);

        int res = solve(coins, amount, 0);
        if(res < MAX_VALUE) {
            return res;
        } else {
            return -1;
        }
    }
}