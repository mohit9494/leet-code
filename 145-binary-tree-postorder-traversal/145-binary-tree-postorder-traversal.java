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
    
    LinkedList<Integer> result = new LinkedList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        
        if(root == null) return result;
        
        // Using LinkedList and AddFirst -> add to the end and then explore => LRN
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(curr);
        
        while(!stack.isEmpty()) {
         
            curr = stack.pop();
            result.addFirst(curr.val);
            
            if(curr.left != null) {
                stack.push(curr.left);
            }
            
             if(curr.right != null) {
                stack.push(curr.right);
            }
            
        }
        
        
        return result;
    }
}