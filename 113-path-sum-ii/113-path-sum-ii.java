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
    
    List<List<Integer>> ans = new ArrayList<>();
    
    private void helper(TreeNode root, int targetSum, List<Integer> ds){
        
        if (root == null) return;      
        
        ds.add(root.val);
        targetSum = targetSum - root.val;
        
        // check if its a leaf node
        if(root.left == null && root.right == null) {
            
            if (targetSum == 0) {
                 ans.add(new ArrayList<>(ds));
            }
            
        }
        
        helper(root.left, targetSum, ds);    
        helper(root.right, targetSum, ds);
        
        // Remove the last added element
         ds.remove(ds.size() - 1);
        
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if (root == null) return ans;
        
        helper(root, targetSum, new ArrayList<>());
        
        return ans;
        
    }
}