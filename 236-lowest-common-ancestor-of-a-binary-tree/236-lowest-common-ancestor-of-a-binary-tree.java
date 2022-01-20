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
    
    // This is flag problem
    
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        
     if (root == null) return null;   
        
     if (root == p || root == q) return root;
       
     TreeNode lh = helper(root.left, p,q); 
        
        TreeNode rh = helper(root.right, p,q);
        
        if(lh == null && rh == null) return null;
        
        if(lh != null && rh != null) return root;
        
        if(lh != null) return lh;
        else return rh;
        
        
    }
    
    public boolean getPath(TreeNode root, TreeNode p, List<TreeNode> path) {
        
        if(root == null) return false;
        
        path.add(root);
        
        if(root.val == p.val) return true;
        
        if(getPath(root.left, p, path) || getPath(root.right, p, path)) return true;
        
        path.remove(path.size() - 1) ;         
        return false;
        
    }
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
     List<TreeNode> path1 = new ArrayList<>();
    List<TreeNode> path2 = new ArrayList<>();
        
        getPath(root,p,path1);
        getPath(root, q, path2);
        
                
        int min = path1.size() > path2.size() ? path2.size() :path1.size();
        List<TreeNode> ans  = new ArrayList<>();
        
        for(int i = 0; i < min; i++) {
            if (path1.get(i).val == path2.get(i).val) {
                ans.add(path1.get(i));
            } else {
                break;
            }
        }
        
        return ans.get(ans.size() - 1); 
    }
}