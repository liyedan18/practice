package com.leetcode.binaryTree.p100.p100.p101;


import com.leetcode.binaryTree.TreeNode;

/**
 101. 对称二叉树

 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

 1
 / \
 2   2
 / \ / \
 3  4 4  3

 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 1
 / \
 2   2
 \   \
 3    3
  
 进阶：

 你可以运用递归和迭代两种方法解决这个问题吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/symmetric-tree
 */
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        //递归方式，需要接住辅助方法
        //比较左子树的左节点和右子树的右节点，左子树的右节点和右子树的左节点
        //终止条件：左右子树不想等，或上面的比较不相等
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        //终止条件
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
