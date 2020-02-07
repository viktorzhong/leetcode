class Solution {
    
    private int[] cache;

    private int solve(int []nums, int idx, int end) {
        if(idx >= end) {return 0;}
        if(cache[idx] >= 0) return cache[idx];
        int res = Math.max(nums[idx] + solve(nums, idx + 2, end), solve(nums, idx + 1, end));
        cache[idx] = res;
        return res;
    }

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        cache = new int[nums.length];
        for(int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        int res1 = solve(nums, 0, nums.length - 1);

        for(int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        int res2 = solve(nums, 1, nums.length);

        return Math.max(res1, res2);
    }
}