class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int rows = triangle.size();
        int[] d = new int[rows + 1];

        for(int i = rows - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                d[j] = Math.min(d[j], d[j + 1]) + triangle.get(i).get(j);
            }
        }
        return d[0];
    }
}