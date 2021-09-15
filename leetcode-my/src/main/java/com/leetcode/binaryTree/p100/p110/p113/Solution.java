package com.leetcode.binaryTree.p100.p110.p113;


import com.leetcode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 */
public class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //dfs、回溯算法，遍历时记录访问路径
        //满足条件时，将该路径添加到结果中

        res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        dfs(root, targetSum, 0, new LinkedList<>());
        return res;
    }

    private void dfs(TreeNode root, int targetSum, int realSum, LinkedList<Integer> singlePath) {
        //结束条件
        if (root == null) {
            return;
        }

        realSum += root.val;
        singlePath.add(root.val);
        //满足条件
        if (root.left == null && root.right == null && realSum == targetSum) {
            res.add(new LinkedList<Integer>(singlePath));
            realSum -= root.val;
            singlePath.removeLast();
            return;
        }

        //遍历条件
        dfs(root.left, targetSum, realSum, singlePath);
        dfs(root.right, targetSum, realSum, singlePath);
        realSum -= root.val;
        singlePath.removeLast();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(s.pathSum(node, 3));

    }
}
