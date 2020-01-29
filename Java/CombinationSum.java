class Solution {
    private void comb(int[] nums, int target, int start, 
                    List<Integer> elem, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(elem));
            return;
        }
        if(target < 0) return;

        for(int i = start; i < nums.length; i++) {
            elem.add(nums[i]);
            comb(nums, target - nums[i], i, elem, res);
            elem.remove(elem.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        comb(candidates, target, 0, elem, result);
        return result;
    }
}