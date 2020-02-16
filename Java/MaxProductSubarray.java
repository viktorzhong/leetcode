class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int min = nums[0], max = nums[0], res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int a = nums[i] * min, b = nums[i] * max, c = nums[i];
            min = Math.min(a, Math.min(b, c));
            max = Math.max(a, Math.max(b, c));
            res = Math.max(max, res);
        }
        return res;
    }
}