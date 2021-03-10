package binaryTree.p54;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 *
 * 思路：
 *      二叉搜索树，中序遍历是递增。
 *      第k大的节点也就是中序遍历倒数第k个节点
 *
 *      优化空间复杂度：o(1)
 *      中序遍历：左根右——>升序
 *          那么，右根左就是降序
 *          那么第k大就是第k个元素
 */
public class Solution2 {
    private int res;
    private int count;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.right);
        --count;
        if (count == 0) {
            res = root.val;
        }

        traverse(root.left);
    }
}