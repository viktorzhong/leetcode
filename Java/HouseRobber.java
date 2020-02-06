class Solution {
    private int[] cache;

    public int solve(int idx, int[] nums) {
        if(idx >= nums.length) return 0;
        if(cache[idx] >= 0) return cache[idx];
        int max = 0;
        max = Math.max(nums[idx] + solve(idx + 2, nums), solve(idx + 1, nums));
        cache[idx] = max;
        return max;
    }

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        cache = new int[nums.length];
        for(int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        return solve(0, nums);    
    }
}