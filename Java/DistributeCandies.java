class Solution {
    public int[] distributeCandies(int candies, int n) {
        int[] res = new int[n];
        int cur = 1;
        int remainings = candies;

        int i = 0;
        while(remainings >= cur) {
            res[i++] += cur;
            remainings -= cur;
            ++cur;
            if(i == n) i = 0;
        }
        if(remainings > 0) res[i] += remainings;
        return res;
    }
}