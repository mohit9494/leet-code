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
    
    public int getLeftHeight(TreeNode root) {
        int level  = 1;
        
        while(root.left != null) {
             level++;
            root = root.left;
           
        }
        
        return level;
    }
    
    public int getRightHeight(TreeNode root) {
        
      
        int level = 1;
        
        while(root.right != null) {
            level++;
            root = root.right;
            
        } 
        
        return level;
    }
    
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;
        
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        
        if(left == right) return (int)Math.pow(2, left) - 1;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
        
    }
}