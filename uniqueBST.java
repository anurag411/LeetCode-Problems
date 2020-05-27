class Solution {
    
    public int numTrees(int n) {
        if(n == 0 || n == 1) 
            return 1;
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        return countTrees(n, dp);
    }
    
    private int countTrees(int n, int []dp) {
        if(n <=1) 
            return 1;
        int sum = 0;
        int lsum = 0;
        int rsum = 0;
        for(int i=1;i<=n;i++) {
            if (dp[i-1] == 0) {
               dp[i-1] = countTrees(i-1, dp);
               lsum = dp[i-1];                      
            } else {
               lsum = dp[i-1];           
            }
            if(dp[n-i] ==0) {
                dp[n-i] = countTrees(n-i, dp);
                rsum = dp[n-i];
            } else {
                rsum = dp[n-i];
            }
            sum = sum +lsum*rsum;
        }
        return sum;
    }
}
