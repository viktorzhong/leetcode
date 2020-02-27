class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1, high = num / 2 + 1;
        while(low <= high) {
            long mid = low + (high - low) / 2;
            long s = mid * mid;
            if(s > num) high = mid - 1;
            else if(s < num) low = mid + 1;
            else return true;
        }
        return false;
    }
}