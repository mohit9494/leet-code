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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        // BFS Using Iterative Queue
        
        if (root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            List<Integer> subList = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                
                TreeNode temp = q.poll();
                subList.add(temp.val);
                
                if (temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                
                
            }
            
            ans.add(subList);
            
        }
        
        return ans;
    }
}