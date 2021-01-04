package com.leetcode.binaryTree.p000.p090.p098;


import com.leetcode.binaryTree.TreeNode;

/**
 * 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 *
 * 思路：
 *      二叉搜索树中序遍历特点：
 *          递增（或者递减）的顺序，也就是说后一个值会大于前一个值
 *
 *          利用中序遍历求解，递归方法
 *          这个思路好
 */
public class Solution2 {
    private long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        //中序遍历框架
        if (!isValidBST(root.left)) {
            return false;
        }

        //具体操作
        if (root.val <= prev) {
            return false;
        }
        prev = root.val;

        if (!isValidBST(root.right)) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        Solution2 s = new Solution2();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(6);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(7);

        System.out.println(s.isValidBST(node));
    }
}
