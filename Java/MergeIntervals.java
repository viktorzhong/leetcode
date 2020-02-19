class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int idx = 0;

        for(int[] in :intervals) {
            if(idx == 0 || res[idx - 1][1] < in[0]) {
                res[idx][0] = in[0];
                res[idx][1] = in[1];
                idx++;
            } else {
                res[idx - 1][1] = Math.max(res[idx - 1][1], in[1]);
            }
        }
        return Arrays.copyOf(res, idx);
    }
}