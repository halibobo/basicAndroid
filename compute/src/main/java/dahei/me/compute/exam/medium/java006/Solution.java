package dahei.me.compute.exam.medium.java006;


/**
 * created by yubosu
 * 2018年12月07日6:18 PM
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtil.getDefaultTreeNode();
        addOneRow(treeNode, 1, 2);
    }

    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        addNode(root, v, d,1);
        return root;
    }

    public static void addNode(TreeNode treeNode,int v, int deep, int start) {
        if (deep == 1) {
            TreeNode treeNodeLeft = new TreeNode(treeNode.val);
            treeNodeLeft.left = treeNode.left;
            treeNodeLeft.right = treeNode.right;
            treeNode.left = treeNodeLeft;
            treeNode.val = v;
            treeNode.right = null;
            return;
        }
        if (treeNode == null || start >= deep) {
            return;
        }
        if (start == deep - 1) {
            TreeNode treeNodeLeft = new TreeNode(v);
            TreeNode treeNodeRight = new TreeNode(v);
            treeNodeLeft.left = treeNode.left;
            treeNodeRight.right = treeNode.right;
            treeNode.left = treeNodeLeft;
            treeNode.right = treeNodeRight;
        } else {
            start++;
            addNode(treeNode.left, v, deep, start);
            addNode(treeNode.right, v, deep, start);
        }
    }


}