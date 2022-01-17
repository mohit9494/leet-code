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
    
    List<Integer> result = new LinkedList<>();
    
    private boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }
    
    private void addLeaves(TreeNode root) {
        
        if(isLeaf(root)) {
            result.add(root.val);
        } else {
            if(root.left != null) addLeaves(root.left);
            
            if(root.right != null) addLeaves(root.right);
        }
        
    }
    
    private void addLeftBoundry(TreeNode root) {
        
        TreeNode curr = root.left;
        
        while(curr != null) {
            
            if(!isLeaf(curr)) result.add(curr.val);
            
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
        
        
    } 
    
    private void addRightBoundry(TreeNode root){
        
        TreeNode curr = root.right;
        List<Integer> tmp = new ArrayList<>();
        
        while(curr != null) {
            
            if(!isLeaf(curr)) tmp.add(curr.val);
            
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        
        for(int i = tmp.size() - 1; i >=0 ; i--) result.add(tmp.get(i));
        
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        if(root == null) return result;
        
        if(!isLeaf(root)) result.add(root.val);
        
        addLeftBoundry(root);
        addLeaves(root);
        addRightBoundry(root);
        
        return result;
        
    }
}