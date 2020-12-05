package com.leetcode.binaryTree.p200.p220.p226;


import com.leetcode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 226 翻转一棵二叉树。

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
    核心就是交换

 层序遍历方式

 */

public class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        //层序遍历框架
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //层序遍历框架
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            //具体业务
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }

            //具体业务

        }

        return root;
    }
}
