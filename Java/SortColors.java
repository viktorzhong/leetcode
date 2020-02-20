class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int red = 0, white = 0, blue = 0;
        
        for(int n : nums) {
            if(n == 0) ++red;
            else if(n == 1) ++white;
            else ++blue;
        }
        int k = 0;
        for(int i = 0; i < red; i++) nums[k++] = 0;
        for(int i = 0; i < white; i++) nums[k++] = 1;
        for(int i = 0; i < blue; i++) nums[k++] = 2;
    }
}