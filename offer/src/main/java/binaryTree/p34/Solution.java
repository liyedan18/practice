package binaryTree.p34;

import binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * 注意：本题与主站 113题相同：https://leetcode-cn.com/problems/path-sum-ii/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 *
 * 思路：
 *      回溯算法
 *      注意是从根节点到叶子节点
 *      全局变量可以用局部方法参数代替
 */
public class Solution {

    private List<List<Integer>> res;
    private int ssum;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new LinkedList<>();
        ssum = sum;
        if (root == null) {
            return res;
        }

        backTrack(root, new LinkedList<Integer>(), 0);
        return res;
    }

    private void backTrack(TreeNode root, LinkedList<Integer> singleRes, int curSum) {

        //满足条件
        // 要加上当前的值，同时是叶子节点
        if (curSum + root.val == ssum && root.left == null && root.right == null) {
            singleRes.add(root.val);
            res.add(new LinkedList<>(singleRes));
            singleRes.removeLast();
            return;
        }

        //遍历选择
        if (root.left != null) {
            singleRes.add(root.val);
            curSum += root.val;
            backTrack(root.left, singleRes, curSum);
            singleRes.removeLast();
            curSum -= root.val;
        }

        if (root.right != null) {
            singleRes.add(root.val);
            curSum += root.val;
            backTrack(root.right, singleRes, curSum);
            singleRes.removeLast();
            curSum -= root.val;
        }
    }

}
