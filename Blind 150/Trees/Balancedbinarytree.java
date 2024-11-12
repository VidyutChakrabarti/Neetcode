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
    public int dfs(TreeNode root){
        if(root == null){return 0;}
        int d = Math.max(dfs(root.left), dfs(root.right)) + 1;
        return d;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(dfs(root.left) - dfs(root.right))>1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
        
    }
}

// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         return checkHeight(root) != -1;
//     }

//     private int checkHeight(TreeNode root) {
//         if (root == null) return 0;

//         int left = checkHeight(root.left);
//         if (left == -1) return -1; // left subtree is unbalanced

//         int right = checkHeight(root.right);
//         if (right == -1) return -1; // right subtree is unbalanced

//         if (Math.abs(left - right) > 1) return -1; // current node is unbalanced

//         return Math.max(left, right) + 1; // return height if balanced
//     }
// }
