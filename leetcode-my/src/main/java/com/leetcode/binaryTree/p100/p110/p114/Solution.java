package com.leetcode.binaryTree.p100.p110.p114;


import com.leetcode.binaryTree.TreeNode;

/**
 给定一个二叉树，原地将它展开为一个单链表。

 例如，给定二叉树

 1
 / \
 2   5
 / \   \
 3   4   6
 将其展开为：

 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list


 //把左子树变成右叉形式
 //保存右子树，然后把左子树挂到根节点右方下面
 //再把原来的右子树挂在现在的右子树最下面

 递归解决：
 1.明确方法的定义（相信方法的含义往下做，不要试图跳入循环。）
     ——这里可以根据定义的各种情况，判断出递归的停止条件
 2.确定方法参数的变量是什么
 3.拿到递归结果要干什么

 */

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        //确定根节点做什么
        //先展平

        flatten(root.left);
        flatten(root.right);

        /** 后序遍历位置 */
        //这时，左右节点都已经展平
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        // while(left!=null){
        //     left = left.right;
        // }
        while (root.right != null) {
            root = root.right;
        }

        root.right = right;

    }
}
