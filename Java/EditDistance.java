class Solution {
    private int min(int a, int b, int c) {
        if(a < b && a < c) return a;
        if(b < a && b < c) return b;
        return c;
    }

    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null) return 0;
        if(word1 == null) return word2.length();
        if(word2 == null) return word1.length();
        int m = word1.length(), n = word2.length();
        int d[][] = new int[m + 1][n + 1];
    
        for(int i = 0; i <= m; i++) d[i][0] = i;
        for(int j = 0; j <= n; j++) d[0][j] = j;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char c1 = word1.charAt(i), c2 = word2.charAt(j);
                if(c1 == c2) {
                    d[i + 1][j + 1] = d[i][j];
                } else {
                    d[i + 1][j + 1] = min(d[i + 1][j], d[i][j + 1], d[i][j]) + 1;
                }
            }
        }

        return d[m][n];
    }
}