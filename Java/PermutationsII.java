class Solution {

    private void permute(List<Integer> nums, int idx, Set<List<Integer>> res) {
        if(idx == nums.size()) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for(int i = idx; i < nums.size(); i++) {
            Collections.swap(nums, i, idx);
            permute(nums, idx + 1, res);
            Collections.swap(nums, i, idx);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int n : nums) list.add(n);
        permute(list, 0, res);

        return new ArrayList<>(res);
    }
}