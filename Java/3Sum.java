class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int k = nums.length - 1; k >= 2; k--) {
            if(nums[k] < 0) break;
            int target = -nums[k], i = 0, j = k - 1;
            while(i < j) {
                if(nums[i] + nums[j] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(i < j && nums[i] == nums[i + 1]) ++i;
                    while(i < j && nums[j] == nums[j - 1]) --j;
                    ++i; --j;
                } else if(nums[i] + nums[j] < target) {
                    ++i;
                } else {
                    --j;
                }
            }
            while(k >= 1 && nums[k] == nums[k - 1]) --k;
        }

        return res;
    }
}
