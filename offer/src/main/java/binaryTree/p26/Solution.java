package binaryTree.p26;

import binaryTree.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 *
 * 思路：
 *      用递归，先判断根节点的值是否相等，然后递归判断左右子树的值是否相等
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        //A树，A的左子树，A的右子树只要有一个能匹配上就可以
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSub(TreeNode a, TreeNode b) {
        //b树结束了，说明匹配完了，是子结构
        if (b == null) {
            return true;
        }
        //a树结束了，b树还没结束，不是子结构
        if (a == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }
        //到这里说明根节点匹配，再匹配左右子树
        return isSub(a.left, b.left) && isSub(a.right, b.right);
    }
}