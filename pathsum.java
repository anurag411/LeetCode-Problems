https://leetcode.com/problems/path-sum-iii/
class Solution {
    
    int result =0;
    HashMap<Integer,Integer> hm = new HashMap<>();
    public int pathSum(TreeNode root, int sum) {
        
        if(root == null)
            return result;
        hm.put(0,1);
        traverse(root, sum, 0);
        return result;
    }
    
    public void traverse(TreeNode root, int sum, int val) {
        
        if(root == null)
            return;
       
        val += root.val;
        if(hm.containsKey(val-sum)) { 
           result+=hm.get(val-sum);
        }
        hm.put(val,hm.getOrDefault(val,0)+1);
        
        traverse(root.left, sum, val);        
        traverse(root.right, sum, val);
        
        hm.put(val,hm.get(val)-1); 
    }
}
