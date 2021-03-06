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
    
    
    private TreeNode  helper(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) return null;
        
        if(root.val == p.val || root.val == q.val) return root;
        
        TreeNode lf = helper(root.left, p , q);
        TreeNode rf = helper(root.right, p ,q);
        
        //If both sides give null then return null
        if (lf == null && rf == null) return null;
        
        if(lf == null) return rf;
        
        if(rf == null) return lf;
        
        return root;
        
    }
    
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
        
        return helper(root, p , q);
        
//         List<TreeNode> path1 = new ArrayList();
//         List<TreeNode> path2 = new ArrayList();
        
//         getPath(root, p, path1);
//         getPath(root, q, path2);
        
//         int min = path1.size() > path2.size() ? path2.size() : path1.size();
        
//         List<TreeNode> test = new ArrayList();
        
//         for(int i = 0; i < min; i++) {
//             if(path1.get(i).val == path2.get(i).val) test.add(path1.get(i));
//             else break;
//         }
        
//         return test.get(test.size() - 1);
        
    }
}