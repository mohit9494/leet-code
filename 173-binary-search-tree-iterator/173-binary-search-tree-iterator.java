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
class BSTIterator {
    
    // Do Inorder -> Store it in Array
    // Mintain a pointer to get next
    // Check if array is iterated -> Index == arr.length
    
    // int index = 0;
    // List<Integer> lst = new ArrayList();
    
    Stack<TreeNode> st = new Stack();
    
    public void pushAll(TreeNode root) {
        while(root != null) {
            st.add(root);
            root = root.left;
        }
    }
    
//     private void inorder(TreeNode root) {
       
//         if (root == null) return;
//         inorder(root.left);
//         lst.add(root.val);
//         inorder(root.right);
//     }

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp = st.pop();
        
        pushAll(temp.right);
        
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */