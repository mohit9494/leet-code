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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean zigZagFlag = false;
        
        while(!q.isEmpty()) {
            
           LinkedList<Integer> subList = new LinkedList<>();
           int size = q.size(); 
            
            for(int i = 0; i< size; i++) {
                
                TreeNode temp = q.poll();
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                
                if(zigZagFlag) subList.addFirst(temp.val);
                else subList.add(temp.val);
            }
            zigZagFlag = !zigZagFlag;
            result.add(subList);
            
        }
        
        
        return result;
        
        
    }
}