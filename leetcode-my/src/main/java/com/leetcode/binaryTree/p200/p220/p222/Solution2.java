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
 *      结合满二叉树和普通二叉树的特点
 *          满二叉树一定是左右深度相同
 *          完全二叉树左右子树一定有一个是满二叉树
 *
 *      结合之后左右子树只会有一边会进行递归
 *
 *      时间复杂度:O(logn*logn)
 *      树的深度O(logn) * 每次递归的时间O(logn)
 */
public class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        /**
         * 满二叉树的判断方法
         */
        TreeNode leftNode = root;
        TreeNode rightNode = root;
        int leftHigh = 1;
        int rightHigh = 1;

        //计算最左侧的深度
        while (leftNode.left != null) {
            leftNode = leftNode.left;
            leftHigh++;
        }
        //计算最右侧分支的深度
        while (rightNode.right != null) {
            rightNode = rightNode.right;
            rightHigh++;
        }
        //满二叉树左右两侧高度一定相等
        if (leftHigh == rightHigh) {
            //满二叉树的节点计算
            int res = (int) Math.pow(2, leftHigh);
            return res - 1;
        }

        /**
         * 到这里是普通二叉树，继续用递归解决
         */

        //遍历框架
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return 1 + left + right;
    }
}
