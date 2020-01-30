class Solution {
    private int res = 0;

    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diff = new HashSet<>();
    private Set<Integer> sum = new HashSet<>();


    public int totalNQueens(int n) {
        if(n <= 0) return res;
        dfs(0, n);
        return res;
    }

    private void dfs(int row, int n) {
        if(row == n) {
            res++;
            return;
        }
        for(int col = 0; col < n; col++) {
            if(!cols.contains(col) && !diff.contains(col - row) && !sum.contains(col + row)) {
                cols.add(col); diff.add(col - row); sum.add(col + row);
                dfs(row + 1, n);
                cols.remove(col); diff.remove(col - row); sum.remove(col + row);
            }
        }
    }
}