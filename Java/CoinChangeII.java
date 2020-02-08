class Solution {
    private int[][] d;
    private int solve(int idx, int amount, int[] coins) {
        if(amount == 0) return 1;
        if(amount < 0 || idx >= coins.length) return 0;

        if(d[idx][amount] >= 0) return d[idx][amount];

        int res = 0;
        res = solve(idx, amount - coins[idx], coins) + solve(idx + 1, amount, coins);
        d[idx][amount] = res;
        return res;
    }

    public int change(int amount, int[] coins) {
        if((coins == null || coins.length == 0) && amount != 0) return 0;
        d = new int[coins.length + 1][amount + 1];
        for(int[] row : d) Arrays.fill(row, -1);

        return solve(0, amount, coins);   
    }
}