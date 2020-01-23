class Solution {

    public int climbStairs(int n) {
        if(n < 1) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int ret = 0, n1 = 1, n2 = 2;
        for(int i = 3; i <= n; i++) {
            ret = n1 + n2;
            n1 = n2;
            n2 = ret;
        }

        return ret;
    }
}