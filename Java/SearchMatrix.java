class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ||
            matrix[0] == null || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int i = mid / n, j = mid % n;
            if(matrix[i][j] < target) low = mid + 1;
            else if(matrix[i][j] > target) high = mid - 1;
            else return true;
        }
        return false;
    }
}