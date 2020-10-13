package com.leetcode.binaryTree.p000.p090.p094;


import com.leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个二叉树，返回它的中序遍历。

 示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,3,2]
 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal

 */


//144二叉树前序遍历
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root ==null){
            return res;
        }
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res){
        if (root ==null){
            return ;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
