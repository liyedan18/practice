package com.leetcode.binaryTree.p100.p100.p103;


import com.leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 103. 二叉树的锯齿形层序遍历

 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

 例如：
 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回锯齿形层序遍历如下：

 [
 [3],
 [20,9],
 [15,7]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal

 思路：
    层序遍历 + 整个单层处理 + 奇偶行数判断
    偶数行时，在添加单层前，先进行反转操作
    奇数行时，则可以直接添加。
 */
public class Solution {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int count = 0;
        //层序遍历：队列，一次一层的方式
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            //用来存储单层的遍历结果，后面还要根据是否偶数行进行反向添加
            List<Integer> singleRes = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = queue.poll();
                singleRes.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }

            count++;
            //当前行是偶数行，则进行反转
            if ((count & 0x1) == 0) {
                Collections.reverse(singleRes);
            }

            res.add(singleRes);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(2);
        one.right = new TreeNode(3);
        one.left.left = new TreeNode(4);
        one.right.right = new TreeNode(5);
        System.out.println(zigzagLevelOrder(one));
    }
}
