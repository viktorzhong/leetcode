class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] d = new int[n];
        d[0] = 1;
        int res = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int cur = nums[i] > nums[j] ? d[j] + 1 : 1;
                d[i] = Math.max(d[i], cur);
            }
            res = Math.max(res, d[i]);
        }
        return res;
    }
}