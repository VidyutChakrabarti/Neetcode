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

    public int depth(TreeNode root){
        if(root == null){return 0;}
        int d = Math.max(depth(root.left), depth(root.right)) + 1;
        return d;
    }

    public int maxDepth(TreeNode root) {
        if(root == null){return 0;}
        int ld = depth(root.left);
        int rd = depth(root.right);
        return Math.max(ld, rd)+1;
        
    }
}
