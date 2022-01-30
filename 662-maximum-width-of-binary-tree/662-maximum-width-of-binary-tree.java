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
    
    int width = 0;
    
    class Tuple{
        
    TreeNode node;
        int num;
        
    public Tuple(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
        
        
    }
    
    
    public int widthOfBinaryTree(TreeNode root) {
        
        
        if(root == null) return width;
        
        Queue<Tuple> q = new LinkedList();
        q.add(new Tuple(root,0));
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            int min = q.peek().num;
            int first=0;
            int last=0;
            
            for(int i = 0; i< size; i++) {
                
                Tuple t = q.poll();
                TreeNode node = t.node;
                
                // calculate id by subtract min from the real val
                int id = t.num - min;
                
                if(i == 0) first = id;
                if(i == size - 1) last = id;
                
                
                if(node.left != null) q.add(new Tuple(node.left, 2*id + 1));
                if(node.right != null) q.add(new Tuple(node.right, 2*id + 2));
            }
            
            width = Math.max(width, last - first + 1);
    
        }
        
        
        return width;

    }
}