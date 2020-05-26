// Bottom's up dynamic programming approach 

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        final int len1 = text1.length();
        final int len2 = text2.length();
        int[][] dp = new int[len2+1][len1+1];
        
        for (int i = len2-1; i >= 0; i--) {
            for (int j = len1-1; j >= 0; j--) {
                dp[i][j] = text2.charAt(i) == text1.charAt(j) 
                    ? 1 + dp[i+1][j+1]
                    : Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }

}
