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
    
    StringBuilder sb = new StringBuilder();
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null) return "#";
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()){
            
            TreeNode temp = q.poll();
            
            if (temp == null) {
                sb.append("# ");
                continue;
            }
            
            sb.append(temp.val + " ");
            
            q.add(temp.left);
            q.add(temp.right);
            
        }
        
        System.out.println(sb);
        return sb.toString();
    }
    
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] nd = data.split(" ");
        int index = 0;
        
        if(nd[index] == "#") return null;
              
        System.out.println(Arrays.toString(nd));        
        Queue<TreeNode> q = new LinkedList();
        
        TreeNode root = new TreeNode(Integer.valueOf(nd[index]));
        q.add(root);
        
        while(!q.isEmpty()) {
            
            TreeNode node = q.poll();
            
            String a = nd[++index];
            String b = nd[++index];
            
            if(!a.equals("#")) {
                node.left = new TreeNode(Integer.valueOf(a));
                q.add(node.left);
            }
            
            if(!b.equals("#")){
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