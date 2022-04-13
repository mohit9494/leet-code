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

class Tuple {
    
    TreeNode node;
    int i;
    
    public Tuple (TreeNode node, int i) {
        this.node = node;
        this.i = i;
    }
    
}

class Solution {
    
    int maxi = 0;
    
    public int widthOfBinaryTree(TreeNode root) {
        
        if (root == null) return maxi;
        
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0));
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            int first = 0;
            int last = 0;
            int min = q.peek().i;
            
        for(int i = 0; i < size; i++) {
            
            Tuple temp = q.poll();
            TreeNode node = temp.node;
            int index = temp.i - min; // IMP
            
            if(i == 0) first = index;
            if(i == size - 1) last = index;
            
            if(node.left != null) q.add(new Tuple(node.left, index * 2 + 1));
            if(node.right != null) q.add(new Tuple(node.right, index * 2 + 2));
                 
        }
            
         maxi = Math.max(maxi, last - first + 1);   
            
            
        }
        
        return maxi;
        
        
    }
}