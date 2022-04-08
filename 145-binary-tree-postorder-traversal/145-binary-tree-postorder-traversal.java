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
    
    LinkedList<Integer> ans = new LinkedList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
     
        if (root == null) return ans;
        
        Stack<TreeNode> st = new Stack();
        st.add(root);
        
        while(!st.isEmpty()) {
            
        TreeNode temp = st.pop();            
        ans.addFirst(temp.val);
        
        if(temp.left != null) st.add(temp.left);
        if(temp.right != null) st.add(temp.right);
            
        }
        
        return ans;
    }
}