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
    
    List<String> result = new ArrayList<>();
    
    private void helper(TreeNode root, String path){
        
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            path += root.val;
            result.add(path);
            return;
        }
        
        path += root.val + "->";
        
        helper(root.left, path);
        helper(root.right, path);
        
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        if(root == null) return result;
        
        String path = "";
        
        helper(root, path);
        
        return result;    
        
        
        
    }
}