package com.leetcode.binaryTree.p100.p100.p104;


import com.leetcode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 104. 二叉树的最大深度（二叉树的高度）

 给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

 3
 / \
 9  20
 /  \
 15   7
 返回它的最大深度 3 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree

 迭代 或 递归

 迭代：层序遍历
     当每一层数据遍历完后，层数计数器+1
 */
public class Solution {
    public int maxDepth(TreeNode root) {

        //层数
        int count = 0;
        if (root == null) {
            return count;
        }

        //每一层的节点个数
        int levelSize = 1;

        //层序遍历框架
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            //具体业务
            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            //具体业务
            if (levelSize == 0) {
                //一层遍历结束
                levelSize = queue.size();
                count++;
            }
        }

        return count;
    }
}
