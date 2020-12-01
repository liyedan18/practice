package com.leetcode.binaryTree.p100.p140.p145;


import com.leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 145 给定一个二叉树，返回它的后序遍历。

 示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [3,2,1]
 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal

    迭代法一：
         类似前序遍历的变种。
         前序遍历：根 -> 左 -> 右 ，倒序后为：右 -> 左 -> 根
         后序遍历：左 ->右 -> 根，即为前序遍历迭代时，左节点比右节点先入栈（则出栈时，左节点会后出栈），
         前序遍历结果即变为：根 ->右 -> 左，最后再倒序（反转Collections.reverse）输出即可。
 */


public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        //前序遍历：单条件，while循环，无脑出栈无脑入
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            //后续遍历先入左节点
            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        //反转前序遍历结果
        Collections.reverse(res);
        return res;
    }
}
