package com.leetcode.dynamicProgram.p300.p330.p337;

import com.leetcode.binaryTree.TreeNode;

/**
 * 337. 打家劫舍 III
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释:小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *     3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释:小偷一晚能够盗取的最高金额= 4 + 5 = 9.
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii/
 *
 * 思路：
 *      最高金额 -> 穷举 -> 动态规划（递归）
 *      dp数组或dp函数
 *
 *      状态：
 *          走到的当前房子
 *      选择：
 *          抢或者不抢
 *      状态转移方程(递归方程)：
 *          第一个root不抢
 *              rob_not = rob(root.left) + rob(root.right)
 *          第一个抢
 *              rob_do = root.val + rob(root.left.left) + rob(root.left.right)
 *                      + rob(root.right.left) + rob(root.right.right)
 *          res = max(rob_not, rob_do)
 *
 *      base case
 *          root==null ,res=0
 *
 *      递归方法，自顶而下
 */
public class Solution {
    public int rob(TreeNode root) {
        //base case
        if (root == null) {
            return 0;
        }

        //root不抢
        int rob_not = rob(root.left) + rob(root.right);
        //root抢
        int rob_do = root.val;
        if (root.left != null && root.right != null) {
            rob_do = root.val + rob(root.left.left) + rob(root.left.right)
                    + rob(root.right.left) + rob(root.right.right);
        } else if (root.left != null) {
            rob_do = root.val + rob(root.left.left) + rob(root.left.right);
        } else if (root.right != null) {
            rob_do = root.val + rob(root.right.left) + rob(root.right.right);
        }

        //或者下面这样简写
        // rob_do = root.val
        //         + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
        //         + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        return Math.max(rob_not, rob_do);
    }
}
