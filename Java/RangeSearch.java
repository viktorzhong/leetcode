class Solution {

    private int binarySearchLastOne(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (target < nums[mid]) high = mid - 1;
      else low = mid + 1;
    }
      return high;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int end = binarySearchLastOne(nums, target);
        int start = binarySearchLastOne(nums, target-1) + 1;
        if (start >= 0 && start <= end && end < nums.length)
            return new int[]{start, end};
        else return new int[]{-1, -1};
    }
}