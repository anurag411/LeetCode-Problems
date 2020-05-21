class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int arr[][] = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix[0].length+1;i++) 
            arr[0][i] = 0;
        for(int i=0;i<matrix.length+1;i++) 
            arr[i][0] = 0;
        int max= 0;
        for(int i=1;i<matrix.length+1;i++) {
            for(int j=1;j<matrix[0].length+1;j++) {
                if (matrix[i-1][j-1] == '1') {
                    arr[i][j] = Math.min(Math.min(arr[i-1][j-1], arr[i-1][j]), arr[i][j-1])+1;
                    max= Math.max(arr[i][j], max);         
                }
            }
        }        
        return max*max;
    }
}
