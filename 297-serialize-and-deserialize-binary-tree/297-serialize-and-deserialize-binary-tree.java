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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null) return "";
        
        StringBuilder path = new StringBuilder();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()) {
           
            TreeNode node = q.poll();
            
            if(node == null) {
             path.append("# ");
                continue;
            }
            path.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        
        
        return path.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data == "") return null;
        
        Queue<TreeNode> q = new LinkedList();
        
        String[] vals = data.split(" ");
        int valIndex = 0;
        
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.add(root);
        
        
        while(!q.isEmpty()) {
          
            TreeNode parent = q.poll();
            
            
            if(!vals[++valIndex].equals("#")) {
                TreeNode tempLeft = new TreeNode(Integer.parseInt(vals[valIndex]));
                q.add(tempLeft);
                parent.left = tempLeft;
            }
            
             if(!vals[++valIndex].equals("#")) {
                TreeNode tempRight = new TreeNode(Integer.parseInt(vals[valIndex]));
                q.add(tempRight);
                parent.right = tempRight;
            }
        }
 
       return root; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));