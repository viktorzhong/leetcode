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
	
	public int rob2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] d = new int[n];
        d[0] = nums[0];
        d[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(d[0], d[1]);

        for(int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 2] + nums[i], d[i - 1]);
            res = Math.max(res, d[i]);
        }

        return res;
    }
}