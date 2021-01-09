package com.leetcode.binaryTree.p200.p220.p222;

import com.leetcode.binaryTree.TreeNode;

/**
 * 222. 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2h个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 *
 * 思路：
 *      完全二叉树：每一层都是紧凑靠左排列的
 *      按照普通二叉树遍历框架处理，直接递归
 *      时间复杂度:O(N)
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //遍历框架
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return 1 + left + right;
    }
}
