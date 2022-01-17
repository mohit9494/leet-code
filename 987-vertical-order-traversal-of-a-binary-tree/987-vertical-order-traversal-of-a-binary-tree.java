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
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    class Tuple{
        
        TreeNode node;
        int row;
        int col;
        
        Tuple(TreeNode n,int r,int c){
            node = n;
            row = r;
            col = c;
        }
        
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        if(root == null) return result;
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        
        q.add(new Tuple(root,0,0));
        
        while(!q.isEmpty()) {
            
            Tuple t = q.poll();
            TreeNode node  = t.node;
            int row = t.row;
            int col = t.col;
            
            if(!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }
            
            if(!map.get(col).containsKey(row)) {
               map.get(col).put(row, new PriorityQueue<>()); 
            }
            
            map.get(col).get(row).offer(node.val);
            
            if(node.left != null) q.add(new Tuple(node.left, row + 1, col - 1));
            if(node.right != null) q.add(new Tuple(node.right, row + 1, col + 1));
            
        }
        
        for(TreeMap<Integer, PriorityQueue<Integer>> i : map.values()) {
            List<Integer> sub = new ArrayList<>();
            
            for(PriorityQueue<Integer> j : i.values()) {
                
                while(!j.isEmpty()) {
                    sub.add(j.poll());
                }
            }
            
            result.add(sub);
        }
        
        return result;
    }
}