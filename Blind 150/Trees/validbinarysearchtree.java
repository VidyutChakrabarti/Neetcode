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
    int res = 0;
    boolean harness(int l, int r, TreeNode root){
        if(root == null){
            return true;
        }
        if(!(root.val>l && root.val<r)){
            return false;
        }
        return harness(l,root.val, root.left) && harness(root.val,r, root.right);
    }
    public boolean isValidBST(TreeNode root) {
        return harness(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
    }
}
