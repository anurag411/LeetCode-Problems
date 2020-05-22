class Solution {
  
    int preorder_idx = 0;  
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    
    int index = 0;
    for (int val : inorder)
      map.put(val, index++);
    return formBinaryTree(0, inorder.length, preorder);
  }

  public TreeNode formBinaryTree(int left, int right, int []preorder) {
    if (left == right)
      return null;
    int val = preorder[preorder_idx];
    TreeNode root = new TreeNode(val);

    int index = map.get(val);
    preorder_idx++;
    
    root.left = formBinaryTree(left, index, preorder);
    root.right = formBinaryTree(index + 1, right, preorder);
    return root;
  }

}
