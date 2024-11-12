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
    int res = Integer.MIN_VALUE;
    int dfs(TreeNode root){
        if(root == null){return 0;}
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(0, root.val + Math.max(left, right));
    }
    int caller(TreeNode root){
        if(root == null){return 0;}
        int l = dfs(root.left);
        int r = dfs(root.right);
        res = Math.max(res, root.val+l+r);
        caller(root.left);
        caller(root.right);
        return res;

    }
    public int maxPathSum(TreeNode root) {
        return caller(root);
    }
}
