package binaryTree.p55;

import binaryTree.TreeNode;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回false 。
 *
 * 限制：
 *
 * 1 <= 树的结点个数 <= 10000
 * 注意：本题与主站 110题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 *
 * 思路：
 *      判断二叉树中root节点的左右子树的深度相差不超过1
 *      还是用递归
 *
 *      求左右子树的深度，如果左右子树的深度相差大于1，则直接返回-1.
 *          如果深度相差不大于1，则返回深度。
 *
 *          最后只需判断树的深度是否等于-1即可
 *
 *          时间复杂度：
 *              O(N),最坏的情况要遍历所有节点
 *          空间复杂度：
 *              O(N),最坏的情况，树退化为链表，则需要O(N)的栈空间
 *
 *          此方法最优
 */
public class Solution3 {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    /**
     * 求树的深度
     */
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左子树深度
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
        //右子树深度
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }

        //不是平衡二叉树，则直接返回-1
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
