package com.leetcode.binaryTree.p100.p110.p110;


import com.leetcode.binaryTree.TreeNode;

/**
 110. 平衡二叉树

 给定一个二叉树，判断它是否是高度平衡的二叉树。

 本题中，一棵高度平衡二叉树定义为：

 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

 示例 1：

 输入：root = [3,9,20,null,null,15,7]
 输出：true
 示例 2：

 输入：root = [1,2,2,3,3,null,null,4,4]
 输出：false
 示例 3：

 输入：root = []
 输出：true
  
 提示：

 树中的节点数在范围 [0, 5000] 内
 -104 <= Node.val <= 104

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/balanced-binary-tree

 思路：
    优化算法，自底向上
    时间复杂度：
        O(n)=自底向上计算，遇到不是平衡二叉树的，则直接返回了
    空间复杂度：
        O(N) 二叉树退化为链表的情况，空间深度

 */
public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        //由底向上的方法
        return recur(root) != -1;
    }

    //如果二叉树是平衡二叉树，则返回实际的高度。不是，则返回-1 *****
    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHigh = recur(root.left);
        if (leftHigh == -1) {
            return -1;
        }
        int rightHigh = recur(root.right);
        if (rightHigh == -1) {
            return -1;
        }

        return Math.abs(leftHigh - rightHigh) <= 1 ? Math.max(leftHigh, rightHigh) + 1 : -1;
    }
}
