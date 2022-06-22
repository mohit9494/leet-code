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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
       
        while (!q.isEmpty()) {
            
        int size = q.size();
            
        boolean xf = false;
        boolean yf = false;
            
        for (int i = 0; i < size; i++) {
            
         TreeNode node = q.poll(); 
            
         if (node.val == x) xf = true;
         if (node.val == y) yf = true;
            
         // check child for same parent
         if (node.left != null && node.right != null) {
             if (node.left.val == x && node.right.val == y) return false;
             if (node.right.val == x && node.left.val == y) return false;
         }
            
         
         if (node.left != null) q.add(node.left);
         if (node.right != null) q.add(node.right); 
            
        }
            
        // After a level is finished
        if (xf && yf) return true;
        if (xf || yf) return false;

        }    
        return false;
    }
}