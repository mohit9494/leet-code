/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private boolean getPath(TreeNode root, TreeNode t, List<TreeNode> path){
        
        if(root == null) return false;
        
        path.add(root);
        
        if(root.val == t.val) return true;
        
        boolean lf = getPath(root.left, t, path);
        boolean rf = getPath(root.right, t, path);
        
        if(lf || rf) return true;
        
        path.remove(path.size() - 1);
        return false;
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //Using Brute Force
        List<TreeNode> path1 = new ArrayList();
        List<TreeNode> path2 = new ArrayList();
        
        getPath(root, p, path1);
        getPath(root, q, path2);
        
        int min = path1.size() > path2.size() ? path2.size() : path1.size();
        
        List<TreeNode> ans = new ArrayList();
        
        for(int i = 0; i < min; i++) {
            
            if(path1.get(i).val == path2.get(i).val) ans.add(path1.get(i));
            else break;
            
        }
        
        return ans.get(ans.size() - 1);
        
    }
}