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
    
    
    List<List<Integer>> result = new ArrayList();
    
    public void helper(TreeNode root, int level) {
        
        if(level == result.size()) {
            LinkedList<Integer> sub = new LinkedList();
            result.add(sub);
        }
        
        if(level % 2 == 0) {
            result.get(level).add(root.val);
        }else {
            result.get(level).add(0,root.val);
        }
        
        if(root.left != null) helper(root.left, level + 1);
        if(root.right != null) helper(root.right, level + 1);
        
    }
    
    public void bfs(TreeNode root) {
        
      Queue<TreeNode> q = new LinkedList();
      q.add(root);
      int level = 0;
        
      while(!q.isEmpty()) {
          
          int size = q.size();
          List<Integer> sub = new ArrayList();
          
          for(int i = 0; i< size; i++) {
              
           TreeNode node  = q.poll();
           if(level % 2 == 0 ){
             sub.add(node.val);  
           } else {
               sub.add(0, node.val);
           }
           
              
           if(node.left != null) q.add(node.left);   
            if(node.right != null) q.add(node.right);
              
              
          }
          result.add(sub);
          level++;
      }  
        
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null) return result;
        bfs(root);
       // helper(root,0);
        return result;
        
    }
}