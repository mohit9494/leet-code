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
    
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
//         if (root == null) return ans;
        
//         ans.add(root.val);
//         preorderTraversal(root.left);
//         preorderTraversal(root.right);
        
//         return ans;
        
        if (root == null) return ans;
        
        Stack<TreeNode> st = new Stack<>();
        
        st.add(root);
        
        while(!st.isEmpty()){
            
            TreeNode temp = st.pop();
            ans.add(temp.val);
            
            if(temp.right!= null) st.add(temp.right);
            if(temp.left != null) st.add(temp.left);
        }
       return ans; 
    }
}