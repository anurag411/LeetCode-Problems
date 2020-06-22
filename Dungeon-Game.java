class Solution {
    public int calculateMinimumHP(int[][] d) {
        int row = d.length;
        int col = d[0].length;
        
        int[][] arr = new int[row][col];
        
        
        // we are follow bottom up approach
        arr[row-1][col-1] = Math.max(1, 1 - d[row-1][col-1]);
        
        for (int i = row - 2; i >= 0; i--)
            arr[i][col-1] = Math.max(1, arr[i+1][col-1] - d[i][col-1]);
        
        for (int i = col - 2; i >= 0; i--)
            arr[row-1][i] = Math.max(1, arr[row-1][i+1] - d[row-1][i]);
        
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                int x = Math.max(1, arr[i+1][j] - d[i][j]);
                int y = Math.max(1, arr[i][j+1] - d[i][j]);
                arr[i][j] = Math.min(x, y);
            }
        }
        
        return arr[0][0];
    }
}
