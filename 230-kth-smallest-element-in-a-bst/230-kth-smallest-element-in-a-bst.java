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
    
    PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
    
    int count = 0;
    
    private void helper(TreeNode root) {
        
        
        
        if (root == null || count == 0) return;
        
        helper(root.left);
        
        if (count == 0) return ;
         // Add in PQ
        q.add(root.val);
        count--;
        
        helper(root.right);
        
       
    
        
    }
    
    public int kthSmallest(TreeNode root, int k) {
        
        count = k;
       
      helper(root);
        
        return q.peek();
        
        
    }
    
    
}