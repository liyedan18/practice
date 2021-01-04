package com.leetcode.binaryTree.p700.p700.p700;


import com.leetcode.binaryTree.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 *
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 例如，
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-a-binary-search-tree
 *
 *
 * 思路：
 *      二叉树遍历框架（递归） + 单节点要做的事
 *      利用二叉树的特点，可以只遍历一边
 */

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }

        if (root.val == val){
            return root;
        }

        if (root.val < val){
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
