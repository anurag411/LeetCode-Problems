class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        return binarySearchRA(nums, target, 0, nums.length-1);
    }
    
    public int binarySearchRA(int[] nums, int target, int begin, int end) {
        if(begin+1 == end) {
            if(target == nums[begin])
                return begin;
            else if(target == nums[end])
                return end;
            return -1;
        }
        if(begin == end) {
            if(target == nums[begin])
                return begin;
            return -1;
        }
        int mid = (begin+end)/2;
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] < target) {
            if(nums[mid] >= nums[end]) {
                return binarySearchRA(nums, target, mid+1, end);
            } else if(nums[mid] < nums[end]) {
                if(target <= nums[end])
                    return binarySearchRA(nums, target, mid+1, end);
                else {
                    return binarySearchRA(nums, target, begin, mid-1);
                }
            }
        } else {
            if(nums[mid] > nums[end]) {
                if(nums[end] >= target)
                    return binarySearchRA(nums, target, mid+1, end);
                else if(nums[end] < target)
                    return binarySearchRA(nums, target, begin, mid-1);       
            } else {
               return binarySearchRA(nums, target, begin, mid-1);    
            }
        }
      return -1;    
    }
}
