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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
//         if(root == null) return ans;
        
//         inorderTraversal(root.left);
//         ans.add(root.val);
//         inorderTraversal(root.right);
        
//         return ans;
        
        if(root == null) return ans;
        Stack<TreeNode> st = new Stack<>();
        
        while(true) {
            
            if (root != null) {
                st.add(root);
                root = root.left;
            }
            else {
               
                if(st.isEmpty()) break;
                
                TreeNode temp = st.pop();                
                ans.add(temp.val);
                
                root = temp.right;
                
            }
        }
        return ans;
    }
}