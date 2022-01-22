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
    
    int preorderIndex = 0;
    Map<Integer, Integer> imap = new HashMap();
    
    public TreeNode treeHelper(int[] preorder, int left, int right) {
      
        // if there are no elements to construct the tree
        if(left > right) return null;
        
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        // BUILD THE LEFT AND RIGHT SUBTREE
        root.left = 
            treeHelper(preorder, left, imap.get(rootValue) - 1);
        
        root.right = treeHelper(preorder, imap.get(rootValue) + 1, right);
        
        return root;
    }
       
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // fill the map with value and index
        for(int i = 0; i< inorder.length; i++) {
            imap.put(inorder[i],i);
        }
        
        // build the tree using helper function
        return treeHelper(preorder, 0, preorder.length - 1);
    }
}