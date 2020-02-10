class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int d[] = new int[nums.length];
        d[0] = nums[0];
        int max = d[0];

        for(int i = 1; i < nums.length; i++) {
            d[i] = Math.max(d[i - 1] + nums[i], nums[i]);
            max = Math.max(d[i], max);
        }

        return max;
    }
}