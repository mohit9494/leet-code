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
    
    // Find the successor
    public int getS(TreeNode root) {
        root = root.right;
        
        while(root.left != null) {
            root = root.left;
        }
        return root.val;
    }
    
    // Find the predecessor
    public int getP(TreeNode root) {
        root = root.left;
        
        while(root.right != null) {
            root = root.right;
        }
        
        return root.val;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) return null;
        
        // Deleted Node is on the right-> move to right
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            // We found the nod eto delete
            // If it is a lea node::
            if(root.left == null && root.right == null) {
                root = null;
            } else if(root.left == null) {
                // Move to right then , replace value with successor and then delete successor
                root.val = getS(root);
                // delete the successor by going to right
                root.right = deleteNode(root.right, root.val);
            } else {
                // root has no right -> replace the root val with predecessor
                root.val = getP(root);
                root.left = deleteNode(root.left, root.val);
                
            }
        }
        
        return root;
        
    }
}