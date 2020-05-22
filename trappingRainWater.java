class Solution {
    public int trap(int[] height) {
        int water = 0;
  
     int leftMax = 0;
     int rightMax = 0;
        int left = 0;
        int right = height.length -1;
        
        while (left<right) {
            if(height[left]<height[right]) {
                if (height[left] >= leftMax) {
                leftMax = height[left];
                left++;
            } else if (height[left]<leftMax) {
                water+=(leftMax - height[left]);
                left++;
            }
            } else {
                if (height[right] >= rightMax) {
                rightMax = height[right];
                right--;
            } else if (height[right]<rightMax) {
                water+=(rightMax - height[right]);
                right--;
            }
            } 
        }
        
        return water;
        
    }
}
