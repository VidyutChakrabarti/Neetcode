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
    List<Integer> res = new ArrayList<>();
    List<Integer> harness(int d, TreeNode root){
        if(root == null){
            return res;
        }
        if (res.size() <= d) {
                while (res.size() <= d) {
                    res.add(0);
                }
            }

        res.set(d, root.val);

        harness(d+1, root.left);
        harness(d+1, root.right);
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        return harness(0, root);
    }
}
