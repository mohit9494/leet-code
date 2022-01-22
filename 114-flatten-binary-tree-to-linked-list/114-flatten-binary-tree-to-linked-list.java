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
      /*  
        // 1 => Recursive   // Go right -> RLN
            if(root == null) return ;
        
            flatten(root.right);
            flatten(root.left);
            
            root.right = prev;
            root.left = null;
            prev = root;*/
   
        /*
        //2 using Stacks
        if(root == null) return ;
        
        Stack<TreeNode> st = new Stack();
        st.add(root);
        
        while(!st.isEmpty()) {
            
            TreeNode node = st.pop();
            
            if(node.right != null) st.add(node.right);
            if(node.left != null) st.add(node.left);
            
            if(!st.isEmpty()) {
                node.right = st.peek();
                node.left = null;
            }
       
        } */
        
        // 3 => Morris Traversal
        
        if(root == null) return ;
        
        TreeNode curr = root;
        
        while(curr != null) {
            
            if(curr.left != null) {
               
                TreeNode temp  = curr.left;
                
                while(temp.right!= null) temp = temp.right;
                
                temp.right = curr.right;
                curr.right = curr.left;
                
            }
            
            curr = curr.right ; 

        }
        
        while(root != null) {
            root.left = null;
            root = root.right;
        }
     
    }
}