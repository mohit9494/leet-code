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
    
    private boolean isMirror(TreeNode left, TreeNode right) {
        
        if(left == null || right == null) return left == right;
        
        return (left.val == right.val && isMirror(left.left, right.right) && 
                isMirror(left.right, right.left));
        
    }
    
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
        
        // return isMirror(root.left, root.right);
        
        // Using Queue
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        
        while(!q.isEmpty()) {
            
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();
            
            if(n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null) return false;
            
            if (n1.val != n2.val) return false;
            
             q.add(n1.left);
             q.add(n2.right);
            
             q.add(n1.right);
             q.add(n2.left);
            
            
        }
        
        return true;
        
    }
}