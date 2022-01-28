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
    
    List<Integer> result = new ArrayList();
    
    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
    
    public void addLeftBoundry(TreeNode root){
        
        if(root == null) return;
        
        while(!isLeaf(root)) {
            
            result.add(root.val);
            
            if(root.left!= null) root = root.left;
            else root = root.right;
            
        }
        
    }
    
        public void addRightBoundry(TreeNode root){
        
        if(root == null) return;
            
        List<Integer> tmp = new ArrayList();
        
        while(!isLeaf(root)) {
            
            tmp.add(0,root.val);
            
            if(root.right!= null) root = root.right;
            else root = root.left;
            
        }
            
         for(int i : tmp) result.add(i);   
        
    }
    
    public void addLeaves(TreeNode root) {
        
        if(root == null) return;
        
        if(isLeaf(root)) {
            result.add(root.val);
        }
        
        addLeaves(root.left);
        addLeaves(root.right);
        
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        if(root == null) return result;
        
        if(!isLeaf(root)) result.add(root.val);
        
        addLeftBoundry(root.left);
        addLeaves(root);
        addRightBoundry(root.right);
        
        return result;
        
    }
}