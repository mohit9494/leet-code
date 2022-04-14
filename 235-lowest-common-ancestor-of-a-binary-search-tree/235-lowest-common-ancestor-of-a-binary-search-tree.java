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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // USING RECURSION
        
        if(root == null) return null;
        
        // if(root.val > p.val && root.val > q.val) {
        //     return lowestCommonAncestor(root.left, p , q);
        // } else if (root.val < p.val && root.val < q.val) {
        //     return  lowestCommonAncestor(root.right, p , q);
        // } 
        
        while(root != null) {
           if(root.val > p.val && root.val > q.val) root = root.left;
            else if (root.val < p.val && root.val < q.val) root = root.right;
            else return root;
        }
        
        return root;
        
    }
}