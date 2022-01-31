/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    StringBuilder rs = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (root == null) return "#";
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            TreeNode node  = q.poll();
            
            if(node == null) {
                rs.append("# ");
            continue;
            }
            
            rs.append(node.val + " ");
            
            q.add(node.left);
            q.add(node.right);
            
            
        }
        
        
        return rs.toString();
        
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] vals = data.split(" ");
        
        int valIndex = 0;
        
        if(vals[valIndex].equals("#")) return null;
        
        Queue<TreeNode> q = new LinkedList(); 
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        q.add(root);
        
        while(!q.isEmpty()) {
            
           TreeNode node  = q.poll();
            String a = vals[++valIndex];
            String b = vals[++valIndex];
            
           if(!a.equals("#")) {
               
               node.left = new TreeNode(Integer.valueOf(a));
               q.add(node.left);
           } 
            
            if(!b.equals("#")) {
               
               node.right = new TreeNode(Integer.valueOf(b));
               q.add(node.right);
           } 
            
        }
        
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));