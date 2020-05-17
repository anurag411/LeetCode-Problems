// https://leetcode.com/problems/binary-tree-level-order-traversal/
class Solution {
    private int maxH =0;
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, 1, res);
        return res;
    }
    
    private void levelOrder(TreeNode root, int h,  List<List<Integer>> res){
        if(root == null)
            return;
        if(maxH<h){
            res.add(new ArrayList<>());
            maxH++;
        }
        res.get(h-1).add(root.val);
        levelOrder(root.left, h+1, res);
        levelOrder(root.right, h+1, res);
    }
    
}
