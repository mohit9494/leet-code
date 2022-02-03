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
    public void flatten(TreeNode root) {
        
        // 1 -> Using Stack -> Like preorder
        
        if(root == null) return;
        
        Stack<TreeNode> st = new Stack();
        st.add(root);
        
        while(!st.isEmpty()) {
            
            TreeNode node = st.pop();
            
            if(node.right != null) st.add(node.right);
            if(node.left != null) st.add(node.left);
            
            if (!st.isEmpty()) node.right = st.peek();
            
            node.left = null;
            
        }
        
   
    }
}