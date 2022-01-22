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
    
    int postorderIndex;
    Map<Integer, Integer> imap = new HashMap();
    
    public TreeNode treeHelper(int[] postorder, int left, int right) {
      
        // if there are no elements to construct the tree
        if(left > right) return null;
        
        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);
        
        // BUILD THE RIGHT AND LEFT SUBTREE
         root.right = treeHelper(postorder, imap.get(rootValue) + 1, right);
        
        root.left = 
            treeHelper(postorder, left, imap.get(rootValue) - 1);
 
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        postorderIndex = postorder.length - 1;
        
        // fill the map with value and index
        for(int i = 0; i< inorder.length; i++) {
            imap.put(inorder[i],i);
        }
        
        // build the tree using helper function
        return treeHelper(postorder, 0, postorder.length - 1);
        
    }
}