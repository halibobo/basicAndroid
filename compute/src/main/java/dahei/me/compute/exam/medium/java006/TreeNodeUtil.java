package dahei.me.compute.exam.medium.java006;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * created by yubosu
 * 2018年12月11日9:52 AM
 */
public class TreeNodeUtil {
    public static void main(String[] args) {
        TreeNode treeNode = getDefaultTreeNode();
//        List<Integer> list = tryPreOrderRecursion(treeNode);
        List<Integer> list = preorderTraversal(treeNode);
        for (Integer integer : list) {
            System.out.println("i:" + integer);
        }
    }

    public static TreeNode getDefaultTreeNode() {
        TreeNode treeNode = new TreeNode(10);
        addNode(treeNode, 2);
        return treeNode;
    }

    private static void addNode(TreeNode treeNode, int deep) {
        if(deep > 0) {
            treeNode.left = new TreeNode(new Random().nextInt(10));
            treeNode.right = new TreeNode(new Random().nextInt(10));
            deep--;
            addNode(treeNode.left, deep);
            addNode(treeNode.right, deep);
        }
    }

    /**
     * 递归先序遍历
     * @param treeNode
     * @return
     */
    public static List<Integer> tryPreOrderRecursion(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        preOrderRecursionLeft(treeNode, list);
        return list;
    }

    private static void preOrderRecursionLeft(TreeNode treeNode,List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.val);
        preOrderRecursionLeft(treeNode.left, list);
        preOrderRecursionLeft(treeNode.right, list);
    }

    /**
     * 非递归先序遍历
     * @param treeNode
     */
    private static List<Integer> preorderTraversal(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        if (treeNode == null) {
            return list;
        }
        treeNodeStack.push(treeNode);
        while (!treeNodeStack.isEmpty()) {
            TreeNode node = treeNodeStack.pop();
            if(node != null) {
                list.add(node.val);
                treeNodeStack.push(node.right);
                treeNodeStack.push(node.left);
            }
        }
        return list;
    }

    /**
     * 递归中序遍历
     *
     * @param treeNode
     * @param list
     */
    private static void preOrderRecursionMiddle(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        preOrderRecursionLeft(treeNode.left, list);
        list.add(treeNode.val);
        preOrderRecursionLeft(treeNode.right, list);
    }
}
