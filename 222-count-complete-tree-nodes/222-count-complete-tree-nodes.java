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
    
    private int getLeftHeight(TreeNode root) {
        
        int level = 0;
        
        while(root != null) {
            root = root.left;
            level++;
        }
        
        return level;
    }
    
    private int getRightHeight(TreeNode root) {
        
        int level = 0;
        
        while(root != null) {
            
            root = root.right;
            level++;
        }
        
        return level;
    }
    
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;
        
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        
        if (lh == rh) return (int) Math.pow(2,lh) - 1;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}