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
    
    
    
    
    private boolean getPath(TreeNode root, TreeNode p, List<TreeNode> l) {
        
        if(root == null) return false;
        
        l.add(root);
        
        if(root.val == p.val) return true;
        
        boolean lf = getPath(root.left, p, l);
        boolean rf = getPath(root.right, p , l);
        
        if(lf || rf) return true;
        
        l.remove(l.size() - 1);
        
        return false;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        List<TreeNode> path1 = new ArrayList();
        List<TreeNode> path2 = new ArrayList();
        
        getPath(root, p, path1);
        getPath(root, q, path2);
        
        int min = path1.size() > path2.size() ? path2.size() : path1.size();
        
        List<TreeNode> test = new ArrayList();
        
        for(int i = 0; i < min; i++) {
            if(path1.get(i).val == path2.get(i).val) test.add(path1.get(i));
            else break;
        }
        
        return test.get(test.size() - 1);
        
    }
}