class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 > len2)
            return findMedianSortedArrays(nums2, nums1);
        if(len1 == 0) {
            int mid = len2/2;
            if(len2 % 2 == 0) 
                return  (double) (nums2[mid-1]+nums2[mid])/2;
            return (double) nums2[mid];
        } 
        if(len2 == 0) {
            int mid = len1/2;
            if(len1 % 2 == 0) 
                return  (double) (nums1[mid-1]+nums1[mid])/2;
            return (double) nums1[mid];
        }
        int start = 0;
        int end = len1;
        int mid = (len1+len2+1)/2;
        while(start <= end) {
            int partitionX = (start+end)/2;
            int partitionY = mid - partitionX;
            int left_X = partitionX != 0 ? nums1[partitionX-1] : Integer.MIN_VALUE;
            int right_X = partitionX != len1 ? nums1[partitionX] : Integer.MAX_VALUE;
            int left_Y = partitionY != 0 ? nums2[partitionY-1] : Integer.MIN_VALUE;
            int right_Y = partitionY != len2 ? nums2[partitionY] : Integer.MAX_VALUE;
            
            if(left_X <=  right_Y && left_Y <= right_X) {
                if((len1+len2) %2 == 0) {
                    return (double) (Math.max(left_X, left_Y) + Math.min(right_X, right_Y))/2;
                } else {
                    return (double) Math.max(left_X, left_Y);
                }
                
            } else if (left_X < right_Y) {
                start = partitionX+1;
            } else
                end = partitionX-1;
        }
       return -1;
    }
}
