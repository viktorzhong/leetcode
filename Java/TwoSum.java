class Solution {
    public int[] twoSum(int[] nums, int target) {
        int []res = new int[]{-1, -1};
        if(nums == null || nums.length == 0) {
            return res;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement) && i != map.get(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return res;
    }
}