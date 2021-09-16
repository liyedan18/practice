package com.leetcode.binaryTree.p100.p120.p129;

import com.leetcode.binaryTree.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 *
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * 示例 2：
 *
 *
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 *  
 *
 * 提示：
 *
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 */
public class Solution {
    private int sum;

    public int sumNumbers(TreeNode root) {
        //1.求出所有的路径组成的数字
        //1.1用dfs、回溯算法。在到达叶子节点时计算总和
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int singleSum) {
        //满足条件，到达叶子结点，一条路径结束
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            singleSum = singleSum * 10 + root.val;
            sum += singleSum;
            return;
        }

        singleSum = singleSum * 10 + root.val;
        dfs(root.left, singleSum);
        // singleSum-=root.val;
        // singleSum+=root.val;
        dfs(root.right, singleSum);
        singleSum = (singleSum - root.val) / 10;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(6);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(7);

    }
}
