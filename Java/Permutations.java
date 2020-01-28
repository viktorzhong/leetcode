class Solution {
    private void helper(List<Integer> nums, int index, List<List<Integer>> res) {
        if(index == nums.size()) {
            res.add(new ArrayList<>(nums));
        } else {
            for(int i = index; i < nums.size(); i++) {
                Collections.swap(nums, i, index);
                helper(nums, index + 1, res);
                Collections.swap(nums, i, index);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }

        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            list.add(num);
        }
        helper(list, 0, res);

        return res;
    }
}