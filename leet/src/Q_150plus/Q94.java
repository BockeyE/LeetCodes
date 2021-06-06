package Q_150plus;

import java.util.ArrayList;
import java.util.List;

/**
 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 内存消耗：36.1 MB, 在所有 Java 提交中击败了99.78% 的用户
 */
public class Q94 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        inOrder(root, ret);
        return ret;
    }

    void inOrder(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        inOrder(root.left, ret);
        ret.add(root.val);
        inOrder(root.right, ret);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}