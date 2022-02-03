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
    
    TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        
        // 3 -> Morris Traversal
        
        TreeNode curr = root;
            
        while(curr != null) {
            
            if(curr.left == null) {
            curr = curr.right;
        }
            else {
                
                // Build the thread
                TreeNode prev = curr.left;
                
                while(prev.right != null) {                   
                   prev = prev.right;  
                }
                
                //connect with curr.right
                prev.right = curr.right;
                
                curr.right = curr.left;
                curr.left = null;
                
                curr = curr.right;
                
                
            }
        }    
        
        
        
        // 2 -> Using Recursion
        // -> RLN -> MOVE Left connection to right
        
//         if(root == null) return;
        
//         flatten(root.right);
//         flatten(root.left);
        
//         root.right = prev;
//         root.left = null;
//         prev = root;
        
        // 1 -> Using Stack -> Like preorder
        
//         if(root == null) return;
        
//         Stack<TreeNode> st = new Stack();
//         st.add(root);
        
//         while(!st.isEmpty()) {
            
//             TreeNode node = st.pop();
            
//             if(node.right != null) st.add(node.right);
//             if(node.left != null) st.add(node.left);
            
//             if (!st.isEmpty()) node.right = st.peek();
            
//             node.left = null;
            
//         }
        
        
   
    }
}