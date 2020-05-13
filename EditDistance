//https://leetcode.com/problems/edit-distance/
class Solution {
    public int minDistance(String word1, String word2) {
        int row=word2.length();
        int col=word1.length();
        int arr[][] = new int[row+1][col+1];
        for(int i=0;i<=col;i++) {
            arr[0][i] = i;
        }
        for(int i=1;i<=row;i++) {
            arr[i][0] = i;
        }
        
        for(int i=1;i<=row;i++) {
            for(int j=1;j<=col;j++) {
                if(word2.charAt(i-1) == word1.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1];
                } else {
                    arr[i][j] = Math.min(Math.min(arr[i-1][j], arr[i-1][j-1]), arr[i][j-1])+1;
                }
            }
        }  
        return arr[row][col];
    }
}
