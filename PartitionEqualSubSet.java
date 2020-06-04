class Solution {

    public boolean canPartition(int[] nums) {
	     
        // sum pf array using lambda function
        
        int totalSum = 0;
        for(int num : nums)
            totalSum += num;
        // sum is odd return false
        if (totalSum  % 2 == 1) {
            return false;
        }	

        int target = (totalSum >> 1);	
        boolean []dp = new boolean[target + 1]; 
        dp[0] = true;	
        for (int num : nums) {		
            for (int j = target; j >= num; -- j) {			
                dp[j] = dp[j] || dp[j - num];
            } 
        }	
        return dp[target];
    }    
}
