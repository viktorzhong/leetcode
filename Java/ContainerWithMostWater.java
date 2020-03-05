class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while(l < r) {
            int s = (r - l) * Math.min(height[l], height[r]);
            res = Math.max(res, s);
            if(height[l] < height[r]) ++l;
            else --r;
        }
        return res;
    }
}