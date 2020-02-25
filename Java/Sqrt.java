class Solution {
    public int mySqrt(int x) {
        long low = 0, high = x / 2 + 1;
        while(low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;
            if(square < x) low = mid + 1;
            else if(square > x) high = mid - 1;
            else return (int)mid;
        }
        return (int)high;
    }
}