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
    
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    private void helper(TreeNode node, int level){
        
        if(ans.size() == level) {
            ans.add(new ArrayList<Integer>());
        }
        
        ans.get(level).add(node.val);
        
        if(node.left!= null) helper(node.left, level + 1);
        if(node.right!= null) helper(node.right, level + 1);
        
        
    }
    
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        // BFS Using DFS
        if(root == null) return ans;
        
        helper(root, 0);
        
        return ans;
        
        
        // BFS Using Iterative Queue
        
//         if (root == null) return ans;
        
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
        
//         while(!q.isEmpty()) {
            
//             int size = q.size();
//             List<Integer> subList = new ArrayList<>();
            
//             for(int i = 0; i < size; i++){
                
//                 TreeNode temp = q.poll();
//                 subList.add(temp.val);
                
//                 if (temp.left != null) q.add(temp.left);
//                 if(temp.right != null) q.add(temp.right);
                
                
//             }
            
//             ans.add(subList);
            
//         }
        
//         return ans;
    }
}