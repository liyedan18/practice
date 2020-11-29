package com.leetcode.binaryTree.p100.p100.p104;


import com.leetcode.binaryTree.TreeNode;

/**
 104. 二叉树的最大深度（二叉树的高度）

 给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

 3
 / \
 9  20
 /  \
 15   7
 返回它的最大深度 3 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree

 递归解法:
    计算出左右子树的深度，则总深度即为  左右子树深度的最大值 + 1
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {

        //层数
        int count = 0;
        if (root == null) {
            return count;
        }

        int leftCount = maxDepth(root.left);
        int rightCount = maxDepth(root.right);

        count = leftCount > rightCount ? leftCount + 1 : rightCount + 1;
        // count = Math.max(leftCount, rightCount) + 1;
        return count;
    }
}
