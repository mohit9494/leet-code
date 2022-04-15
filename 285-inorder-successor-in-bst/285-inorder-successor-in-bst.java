/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
   TreeNode s = null;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
     
        if (root == null) return s;
        
        while(root != null) {
            
            if(root.val <= p.val) {
                root = root.right;
            } else if (root.val > p.val) {
                s = root;
                root = root.left;
            }
     
        }
        
        
        return s;
        
    }
}