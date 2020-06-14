class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        int[] temp = new int[length];
        int[] dp = new int[length];
        Arrays.fill(temp, 1);
        
        int max = 0;
        for (int i = 1; i < length; i++) {
            int e = nums[i];
            for (int j = 0; j < i; j++) {
                if (e%nums[j] == 0) {
                    if(temp[i] < temp[j]+1){
                        dp[i] = j;
                        temp[i] = temp[j]+1;
                    }
                }
            }
            if(temp[i] > temp[max]){
                max = i;
            }
        }
        
        int k =max;
        for (int i = temp[max]; i > 0; i--) {
            res.add(nums[k]);
            k = dp[k];
        }
        return res;
    }
}
