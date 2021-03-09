package binaryTree.p33;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 *
 * 提示：
 *
 * 数组长度 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 *
 * 思路：
 *     根据二叉搜索树后序遍历特点，根节点左子树全都<根节点<右子树
 *     递归判断【左右子树区间】是否满足以上特点
 *     数组中第一个大于根节点的值是右子树开始的位置
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1) {
            return true;
        }

        //需要根节点位置，右子树位置
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int leftBound, int rightBound) {

        if (leftBound > rightBound) {
            return true;
        }

        int leftStart = leftBound;
        int rootVal = postorder[rightBound];
        //寻找左子树区间
        while (postorder[leftBound] < rootVal) {
            leftBound++;
        }
        int newLeftBound = leftBound - 1;

        //寻找右子树区间
        while (postorder[leftBound] > rootVal) {
            leftBound++;
        }
        int newRightBound = leftBound - 1;

        //到这里，应该循环完当前区间
        if (leftBound != rightBound) {
            return false;
        }

        //递归判断左右子树区间
        return verifyPostorder(postorder, leftStart, newLeftBound)
                && verifyPostorder(postorder, newLeftBound + 1, newRightBound);
    }
}
