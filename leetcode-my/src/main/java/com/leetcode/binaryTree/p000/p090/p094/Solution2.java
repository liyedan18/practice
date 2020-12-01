package com.leetcode.binaryTree.p000.p090.p094;


import com.leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 094 给定一个二叉树，返回它的中序遍历。

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

 非递归解法：
    双条件，while循环，移动指针先开路，非空入栈先往左，空了出栈再往右
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null){
            return resList;
        }

        Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);  //这一步不需要，不是前序遍历，不用一开始就把根节点放入栈
        //移动指针
        TreeNode pNode = root;
        // 双条件，while循环，
        while(pNode != null || !stack.isEmpty()){

            // 非空入栈先往左，空了出栈再往右
            if (pNode != null){
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode tempNode = stack.pop();
                resList.add(tempNode.val);
                pNode = tempNode.right;
            }
        }

        return resList;
    }
}
