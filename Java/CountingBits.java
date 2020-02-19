class Solution {
    public int[] countBits(int num) {
        int[] d = new int[num + 1];
        for(int i = 1; i <= num; i++) {
            d[i] = d[i & (i - 1)] + 1;
        }
        return d;
    }
}