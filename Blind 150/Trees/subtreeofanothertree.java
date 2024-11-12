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
    public boolean sameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null || p.val != q.val){
            return false;
        }else{
            boolean f = sameTree(p.left, q.left); 
            boolean s = sameTree(p.right, q.right); 
            return f && s;
        }
    }

    boolean lookup(TreeNode root, TreeNode subRoot){
        if(root == null){
            return false;
        }
        if(root.val == subRoot.val && sameTree(root, subRoot)){
            return true;
        }else{
            return lookup(root.left, subRoot) || lookup(root.right, subRoot);
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        return lookup(root, subRoot);
    }
}
