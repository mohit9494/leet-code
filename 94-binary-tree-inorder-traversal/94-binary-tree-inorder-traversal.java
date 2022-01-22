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
    
    // LNR
    
    List<Integer> result = new ArrayList<Integer>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        // Morris Traversal
        TreeNode cur = root;
        
        while(cur != null) {
            
            if(cur.left == null) {
               result.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode temp = cur.left;
                
                while(temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }
                
                if(temp.right == null) {
                    temp.right = cur;
                    cur = cur.left;
                } else {
                    temp.right = null;
                    result.add(cur.val);
                    cur = cur.right;
                }
            } 
           
            
        }
        
     /*  if(root == null) return result; 
        
       Stack<TreeNode> st = new Stack<>(); 
        
        TreeNode node = root;
        
        while(true) {
            
            if(node!= null) {
                st.push(node);
                node = node.left;
            } else {
                
                if(st.isEmpty()) break;
                
                node  = st.pop();
                result.add(node.val);
                node = node.right;
                
            }
   
        } */
        
        return result;
        
    }
}