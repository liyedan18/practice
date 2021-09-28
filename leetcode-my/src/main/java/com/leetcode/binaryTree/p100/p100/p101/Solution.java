package com.leetcode.binaryTree.p100.p100.p101;


import com.leetcode.binaryTree.TreeNode;

import java.util.LinkedList;

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
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        //迭代方式，用队列
        //先比较左节点和右节点是否相等
        //相等则把左子树的左节点、右子树的右节点、左子树的右节点、右子树的左节点按顺序添加到队列
        //然后比较左子树的左节点和右子树的右节点，左子树的右节点和右子树的左节点
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0) {
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }
}
