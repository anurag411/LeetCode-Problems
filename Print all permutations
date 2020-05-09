//
class Solution {
    public void swap(int i , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void rec(int start, int[] nums, List<List<Integer>> result){
        int n = nums.length;
        if(start == n){
            List<Integer> list = new ArrayList<>();
            for(int a : nums)
                list.add(a);
            result.add(list);
            return;
        }
        
        for(int i=start; i<n; i++){
            swap(start, i, nums);
            rec(start+1, nums, result);
            swap(start, i, nums);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0)
            return result;
        
        rec(0,nums,result);
        
        return result;
    }
}
