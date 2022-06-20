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
    
    private void pathBuilder(TreeNode root, int targetSum, List<Integer> ds) {
        
        if(root == null) return;
        
        // use the root value
        targetSum -= root.val;
        ds.add(root.val);
        
        // check if its a root node
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                // You got the perfect path Now !
                ans.add(new ArrayList<>(ds));
            }
        }
        
        // Go left and right
        pathBuilder(root.left, targetSum, ds);
        pathBuilder(root.right, targetSum, ds);
            
        // BackTracking
        ds.remove(ds.size() - 1);
        
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if (root == null) return ans;
        
        pathBuilder(root, targetSum, new ArrayList<Integer>());        
        
        return ans;
    }
}