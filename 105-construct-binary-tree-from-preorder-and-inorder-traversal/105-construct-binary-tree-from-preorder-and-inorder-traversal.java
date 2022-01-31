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
    
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap();
    
    private TreeNode treeHelper(int[] preorder, int left, int right){
        
        // If no elements are there to construct the tree
        if(left > right) return null;
        
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        // Move through the range of Inorder
        root.left = treeHelper(preorder, left, map.get(rootValue) - 1);
        root.right = treeHelper(preorder, map.get(rootValue) + 1, right);
            
        return root;    
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // Create Map from inorder -> Used to find Left and right subtree
        for(int i = 0 ; i<= inorder.length - 1; i++) map.put(inorder[i], i);
        
        // Build Tree using preorder and Helper -> Preorder Gives root element
        return treeHelper(preorder, 0, inorder.length - 1);
        
    }
}