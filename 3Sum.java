class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int length = nums.length;
        for(int i=0;i<length-2;i++) {
            int left =i+1;
            int right = length-1;
            int sum = 0;
            while(i < length && left < right) {
                List<Integer> list = new ArrayList<>(); 
                if(sum == (nums[i]+nums[left]+nums[right])) {
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                } else if(sum > (nums[i]+nums[left]+nums[right])) {
                    left++;
                } else {
                    right--;
                }
            }
        }
     Iterator<List<Integer>> it = res.iterator();
     while(it.hasNext()) {
        result.add(it.next());
     }
        return result;
    }
}
