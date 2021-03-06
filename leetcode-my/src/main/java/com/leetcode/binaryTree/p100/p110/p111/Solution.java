package com.leetcode.binaryTree.p100.p110.p111;


import com.leetcode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例 1：
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 *
 *
 * 思路：
 *      BFS——二叉树层序遍历(队列)——一次while循环遍历一个节点
 *      记录已走的层数找到叶子结点就返回
 */

public class Solution {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        //层序遍历框架——一次while循环遍历一个节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //层数
        int levelSize = 1;
        //每一层的节点数
        int levelNodeSize = queue.size();

        while (!queue.isEmpty()) {
            levelNodeSize--;
            TreeNode node = queue.poll();

            //叶子结点
            if (node.left == null && node.right == null) {
                return levelSize;
            }

            //遍历扩散与node相连的节点，并加入队列
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            //一层的节点全部遍历完成
            if (levelNodeSize == 0) {
                // 下一层节点个数
                levelNodeSize = queue.size();
                if (levelNodeSize > 0) {
                    levelSize++;
                }
            }
        }

        return levelSize;
    }
}
