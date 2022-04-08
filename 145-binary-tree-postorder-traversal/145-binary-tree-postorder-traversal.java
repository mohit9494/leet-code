/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    LinkedList<Integer> result = new LinkedList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
     
        if (root == null) return result;
        
        Stack<TreeNode> st = new Stack();
        st.add(root);
        
        while(!st.isEmpty()) {
            
      TreeNode node = st.pop();
      result.addFirst(node.val); //add it int the end

      if(node.left != null) st.add(node.left);
      if(node.right != null) st.add(node.right);
            
        }
        
        return result;
    }
}