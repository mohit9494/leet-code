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
    
    public void markParent(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            TreeNode node = q.poll();
            
            if(node.left!=null) {
                q.add(node.left);
                parentMap.put(node.left, node);
            }
            
             if(node.right!=null) {
                q.add(node.right);
                parentMap.put(node.right, node);
            }
            
            
        }
        
    }
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        
        markParent(root, parentMap);
        
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(target);
        vis.put(target, true);
        
        int level = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            if(level == k) break;
            level++;
            
            for(int i = 0; i< size; i++) {
                
                TreeNode node = q.poll();
                
                if(node.left != null && vis.get(node.left) == null) {
                    q.add(node.left);
                    vis.put(node.left, true);
                }
                
                 if(node.right != null && vis.get(node.right) == null) {
                    q.add(node.right);
                    vis.put(node.right, true);
                }
                
                 if(parentMap.get(node) != null && vis.get(parentMap.get(node)) == null) {
                    q.add(parentMap.get(node));
                    vis.put(parentMap.get(node), true);
                }
                
                
            }
            
            
            
            
        }
        
        
        List<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty()) ans.add(q.poll().val);
        
        return ans;
        
    }
}