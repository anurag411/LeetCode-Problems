class Solution {
    
    private int max_sum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if(root == null) 
            return 0;
        int max = maxPath(root);
        return max_sum;
    }
    
    private int maxPath(TreeNode root) {
        if(root == null) {
            return -100000;
        }
        if(root.left == null && root.right == null) {
            max_sum = Math.max(max_sum, root.val);
            return root.val;
        }
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        int temp_max = 0;
        temp_max = findMax(left+root.val, right+root.val, root.val);
        int temp_max1 = findMax(left, right, temp_max);
        temp_max1 = Math.max(left+right+root.val, temp_max1);
        max_sum = Math.max(max_sum, temp_max1);
        return temp_max;
    }
    
    private int findMax(int x, int y, int z) {
        if(x > y) {
            if(x > z)
                return x;
            return z;
        } else {
            if(y > z)
                return y;
            return z;
        }
    }
}
