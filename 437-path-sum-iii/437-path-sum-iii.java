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
    
    int total = 0;
 
    private void helper(TreeNode root, int targetSum, int sum, Map<Integer, Integer> map) {
        
     if (root == null) return ;
        
     sum = sum + root.val;
        
     if (map.containsKey(sum - targetSum)) {
         total += map.get(sum - targetSum);
     }
    
     map.put(sum, map.getOrDefault(sum, 0) + 1);
        
     helper(root.left, targetSum, sum, map);
     helper(root.right, targetSum, sum, map);
        
        // remove the current sum from the hashmap
        // in order not to use it during 
        // the parallel subtree processing
        
        map.put(sum, map.get(sum) - 1);
        
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        
        if (root == null) return total;
        
            
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        helper(root, targetSum, 0, map);
        
        return total;
        
    }
}