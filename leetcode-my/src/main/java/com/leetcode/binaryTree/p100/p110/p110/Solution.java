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
    双重递归
    时间复杂度：
        O(nlogn)=O(N)遍历n个节点 * 每个节点都要递归logn层计算高度
    空间复杂度：
        O(N) 二叉树退化为链表的情况

    想到了递归的思想，但是不知道如何“结合”计算高度和计算是否平衡两个方法。
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //左右子树的高度差是否大于1
        if (Math.abs(deep(root.left) - deep(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    //求二叉树的深度
    private int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(deep(root.left), deep(root.right)) + 1;
    }
}
