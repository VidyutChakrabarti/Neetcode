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
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        
        TreeNode parent = null;
        TreeNode cur = root;
        
        // Find the node to delete
        while (cur != null && cur.val != key) {
            parent = cur;
            if (key > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        
        if (cur == null) return root;
        
        // Node with only one child or no child
        if (cur.left == null || cur.right == null) {
            TreeNode child = (cur.left != null) ? cur.left : cur.right;
            if (parent == null) return child;
            if (parent.left == cur) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            // Node with two children
            TreeNode par = null; // parent of right subtree's min node
            TreeNode delNode = cur;
            cur = cur.right;
            while (cur.left != null) {
                par = cur;
                cur = cur.left;
            }
            
            if (par != null) { // if there was a left traversal
                par.left = cur.right;
                cur.right = delNode.right;
            }
            cur.left = delNode.left;
            
            if (parent == null) return cur; // if deleting root
            
            if (parent.left == delNode) {
                parent.left = cur;
            } else {
                parent.right = cur;
            }
        }
        
        return root;
    }
}

//iterative solution