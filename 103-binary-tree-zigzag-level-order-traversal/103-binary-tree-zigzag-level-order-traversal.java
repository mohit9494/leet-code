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
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if (root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        int level = 1;
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            
            LinkedList<Integer> subList = new LinkedList<>();
            
            for(int i = 0; i < size; i++) {
                
                TreeNode temp = q.poll();
                
                if(temp.left!= null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                
                if(level > 0) subList.add(temp.val);
                else subList.addFirst(temp.val);
                
            }
            
            result.add(subList);
            
            level *= -1;
            
        }
        
        return result;
    }
}