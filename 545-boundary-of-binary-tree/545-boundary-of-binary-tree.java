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
    
    // Add Left, Add Leaf, Add Right in reverse
    
    LinkedList<Integer> result = new LinkedList<>();
    
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
    
    private void addLeft(TreeNode root) {
        
       TreeNode curr = root;
        
       while(curr != null) {
           
          if(!isLeaf(curr)) result.add(curr.val);
          
          if(curr.left != null) curr = curr.left;
          else curr = curr.right;
           
       } 
        
        
    }
    
    private void addRight(TreeNode root) {
        
        TreeNode curr = root;
        
        LinkedList<Integer> subList = new LinkedList();
        
        while(curr != null) {
            
            if( !isLeaf(curr)) subList.addFirst(curr.val);
            
            if(curr.right!= null) curr = curr.right;
            else curr = curr.left;
            
        }
        
        for(int i : subList) result.add(i);
        
    }
    
    private void addLeaf(TreeNode root) {
        
        if(root == null) return;
        
        if(isLeaf(root)) result.add(root.val);
        
         addLeaf(root.left);
         addLeaf(root.right);
        
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        if(root == null) return result;
        
        if(isLeaf(root))  {
            
            result.add(root.val);
            return result;
        }
        
        
        result.add(root.val);
        
        addLeft(root.left);
        addLeaf(root);
        addRight(root.right);
        
        return result;
        
    }
}