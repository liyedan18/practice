package com.leetcode.binaryTree.p100.p140.p144;


import com.leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个二叉树，返回它的 前序 遍历。

  示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,2,3]
 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal

 */


public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }
        res.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);

        if (left==null&&right==null){
            return res;
        }

        if(left!=null){
            left.forEach(i -> res.add(i));
        }
        if(right!=null){
            right.forEach(i -> res.add(i));
        }
        return res;
    }
}
