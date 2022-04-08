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
    public int maxDepth(TreeNode root) {
        
        // Using BFS
        
        if(root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        int level = 0;
        
    while(!q.isEmpty()) {

       int size = q.size();

        for(int i = 0; i < size; i++) {

            TreeNode temp = q.poll();

            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }

        level++;
    }
        
        return level;
        
//         if (root == null) return 0;
        
//         int ld = maxDepth(root.left);
//         int rd = maxDepth(root.right);
        
//        return 1 + Math.max(ld, rd);
        
    }
}