//https://leetcode.com/problems/unique-paths/

class Solution {
    public int uniquePaths(int m, int n) {
        // check basic conditions
        if(m == 0)
            return 0;
        if(m == 1 || n == 1)
            return 1;
        
        int arr[] = new int[n]; // Arrays of integer which store column values corrsponding to that row.
        int top =0;  // stores last column calculated value
        for(int j=0;j<n;j++) {
            arr[j] = 1;
        }
        for(int i=1;i< m;i++) {
            top = 0;
            for(int j=0;j<n;j++) {
               arr[j] = arr[j]+top;
               top = arr[j]; 
            }         
        }
        return top;
    }
}
