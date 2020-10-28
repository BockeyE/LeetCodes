package Q_140_149.Q144;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：36.4 MB, 在所有 Java 提交中击败了97.90% 的用户
 */
public class Q144 {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        preWhile(ret, root);
        return ret;
    }

    public void preOrder(List<Integer> ret, TreeNode node) {
        if (node == null) {
            return;
        }
        ret.add(node.val);
        preOrder(ret, node.left);
        preOrder(ret, node.right);
    }


    public void preWhile(List<Integer> ret, TreeNode node) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode treeNode = node;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                ret.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    public static class TreeNode {
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


    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3, null, null);

        TreeNode n2 = new TreeNode(2, n3, null);

        TreeNode n1 = new TreeNode(1, null, n2);
        new Q144().preorderTraversal(n1);
    }
}
