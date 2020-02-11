class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0) return 0;
        if(cost.length == 1) return cost[0];

        int a = cost[0], b = cost[1];
        for(int i = 2; i < cost.length; i++) {
            int cur = Math.min(a, b) + cost[i];
            a = b;
            b = cur;
        }
        return Math.min(a, b);
    }
}