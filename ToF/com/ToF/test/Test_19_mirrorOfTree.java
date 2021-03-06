package com.ToF.test;

/**
 * @Author:
 * @Description:题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *              思路： 我们先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子结点。当交换完所有非叶子结点的左右子结点之后，就得到了树的镜像。
 * @params:
 * @Data: Created in  13:41 2018/8/8
 * @Modified By:
 */
public class Test_19_mirrorOfTree {
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static void mirror(BinaryTreeNode node){
        //校验，当前节点为空，则不进行操作
        if (node!=null){
            //交换节点左右两个子树
            BinaryTreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            //对节点的左右两个子树进行处理
            mirror(node.left);
            mirror(node.right);
        }
    }

    public static void printTree(BinaryTreeNode node){
        if (node != null){
            printTree(node.left);
            System.out.print(node.value+" ");
            printTree(node.right);
        }
    }

    public static void main(String[] args) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 8;
        root.left = new BinaryTreeNode();
        root.left.value = 6;
        root.left.left = new BinaryTreeNode();
        root.left.left.value = 5;
        root.left.right = new BinaryTreeNode();
        root.left.right.value = 7;
        root.right = new BinaryTreeNode();
        root.right.value = 10;
        root.right.left = new BinaryTreeNode();
        root.right.left.value = 9;
        root.right.right = new BinaryTreeNode();
        root.right.right.value = 11;
        printTree(root);
        System.out.println();
        mirror(root);
        printTree(root);

    }

}
