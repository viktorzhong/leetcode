class Solution {

    private void helper(int[] nums, int start,
                       List<Integer> elem, List<List<Integer>> result) {
        result.add(new ArrayList<>(elem));
        for(int i = start; i < nums.length; i++) {
            elem.add(nums[i]);
            helper(nums, i+1, elem, result);
            elem.remove(elem.size() - 1);
        }
  }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        helper(nums, 0, elem, res);

        return res;
    }
}