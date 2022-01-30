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
    
    List<Integer> ans  = new ArrayList();
    
    private void buildParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap){
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            TreeNode node = q.poll();
            
            if(node.left != null) {
                q.add(node.left);
                parentMap.put(node.left, node);
            }
            
             if(node.right != null) {
                q.add(node.right);
                parentMap.put(node.right, node);
            }
            
        }
        
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        if(root == null) return ans;
        
        Map<TreeNode, TreeNode> parentMap = new HashMap();        
        // Build parent Map
        buildParentMap(root, parentMap);
        
        Queue<TreeNode> q = new LinkedList();
        q.add(target);
        
        Set<TreeNode> vis = new HashSet();
        vis.add(target);
        
        int level = 0;
        
        while(!q.isEmpty()) {
            
          if(level == k) break;  
          int size = q.size();
            
            
          for(int i = 0; i< size; i++) {
              
             TreeNode node = q.poll(); 
             
             if(node.left != null && !vis.contains(node.left)) {
                 q.add(node.left);
                 vis.add(node.left);
             } 
              
               if(node.right != null && !vis.contains(node.right)) {
                 q.add(node.right);
                 vis.add(node.right);
             } 
              
              if(parentMap.get(node) != null && !vis.contains(parentMap.get(node))) {
                 q.add(parentMap.get(node));
                 vis.add(parentMap.get(node));
             }  
          } 
            
            level++;
            
        }
        
        while(!q.isEmpty()) ans.add(q.poll().val);
        return ans;
    }
}