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
    int temp = 0;
    int harness(int max, TreeNode root){
        if(root == null){
            return res;
        }
        if(max<=root.val){
            res+=1;
            //if(max==Integer.MIN_VALUE){temp=root.val;}else{temp = max;}
            max = root.val;
        }
        harness(max, root.left);
        harness(max, root.right);
        return res;
    }

    public int goodNodes(TreeNode root) {
        return harness(Integer.MIN_VALUE, root);
    }
}
