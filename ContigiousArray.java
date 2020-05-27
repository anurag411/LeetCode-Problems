class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0; 
        // count maintains the value of 1's and 0's if it negative means 0 are more and it is positive the 1's are more.
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}
