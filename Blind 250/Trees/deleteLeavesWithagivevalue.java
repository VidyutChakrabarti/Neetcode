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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, visited = null;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.peek();
            if (cur.right != null && cur.right != visited) {
                cur = cur.right;
                continue;
            }

            stack.pop();
            if (cur.left == null && cur.right == null && cur.val == target) {
                if (stack.isEmpty()) return null;

                TreeNode parent = stack.peek();
                if (parent.left == cur) {
                    parent.left = null;
                } else if (parent.right == cur) {
                    parent.right = null;
                }
            } else {
                visited = cur;
            }

            cur = null;
        }

        return root;
    }
}

//iterative postorder traversal optimal