package com.leetcode.binaryTree.p200.p220.p226;


import com.leetcode.binaryTree.TreeNode;

/**
 翻转一棵二叉树。

 示例：

 输入：

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 输出：

 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 备注:
 这个问题是受到 Max Howell 的 原问题 启发的 ：

 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/invert-binary-tree



 思路：
 把每个节点的左右子树都翻转，那么整个二叉树就镜像了。

 递归解决：
 1.明确方法的定义（相信方法的含义往下做，不要试图跳入循环。）
     ——这里可以根据定义的各种情况，判断出递归的停止条件
 2.确定方法参数的变量是什么
 3.拿到递归结果要干什么

 */

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        /** 后序遍历位置 */
        //拿到递归结果做什么——交换已经反转的左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;

    }
}
