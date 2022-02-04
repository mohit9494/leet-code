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
            
            if(p.val >= root.val) {
                root = root.right;
            } else {
                s = root;
                root = root.left;
            }
     
        }
        
        
        return s;
        
    }
}