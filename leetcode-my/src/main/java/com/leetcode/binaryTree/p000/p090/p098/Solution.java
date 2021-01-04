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
 *      这个做法不好理解
 *
 *      二叉搜索树特点：
 *          左子树上所有节点的值都小于根节点的值
 *          右子树上所有节点的值都大于根节点的值
 *          左右子树也符合上面特点
 *
 *      二叉树遍历框架（递归） + 单节点要做的事
 *      单节点要判断符合上面的条件
 *      根节点左子树上的所有左节点，小于自己的根节点，且小于总根节点
 *      根节点左子树上的所有右节点，大于自己的根节点，且小于总根节点
 *      根节点右子树上的所有左节点，小于自己的根节点，且大于总根节点
 *      根节点右子树上的所有右节点，大于自己的根节点，且大于总根节点
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(6);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(7);

        System.out.println(s.isValidBST(node));
    }

    //这样有问题，只是判断了单个左子树节点小于root，没有判断所有的左子树节点都小于root
    public boolean isValidBST1(TreeNode root) {
        if (root == null){
            return true;
        }

        if (root.left!=null && root.left.val>= root.val){
            return false;
        }
        if (root.right!=null && root.right.val<= root.val){
            return false;
        }

        return isValidBST1(root.left)&& isValidBST1(root.right);
    }
}
