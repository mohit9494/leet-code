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
    
    
    List<List<Integer>> result = new ArrayList();
    
    class Tuple {
        
        TreeNode node;
        int r;
        int c;
        
        public Tuple(TreeNode node, int r, int c) {
            this.node = node;
            this.r = r;
            this.c = c;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        if(root == null) return result;
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap();
        Queue<Tuple> q = new LinkedList(); 
        q.add(new Tuple(root,0,0));
        
        while(!q.isEmpty()) {
            
            Tuple t = q.poll();
            TreeNode node = t.node;
            int r = t.r;
            int c = t.c;
            
            if(!map.containsKey(c)) {
                map.put(c, new TreeMap<>());
            }
            
            if(!map.get(c).containsKey(r)) {
                map.get(c).put(r, new PriorityQueue<>());
            }
            
            map.get(c).get(r).add(node.val);
            
            if(node.left != null) q.add(new Tuple(node.left, r + 1, c - 1));
            if(node.right != null) q.add(new Tuple(node.right, r + 1, c + 1));
            
        }
        
        for(TreeMap<Integer, PriorityQueue<Integer>> i : map.values()) {
            
            List<Integer> sub = new ArrayList();
            
            for(PriorityQueue<Integer> j :i.values()) {
               
                while(!j.isEmpty()) sub.add(j.poll());
                
            }
            
            result.add(sub);
        }
        
        return result;
        
    }
}