package com.leetcode.binaryTree.p100.p100.p102;


import com.leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 102. 二叉树的层序遍历

 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

 示例：
 二叉树：[3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]

 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //层序遍历，用队列.
        //根据从左到右，从上到下的特点。先访问的节点，其左子树和右子树也一定是先访问的。
        //符合队列的特点
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();

        int levelSize = 1;

        //层序遍历框架
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //层序遍历框架
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            //具体业务操作
            //如何判断哪些数据在同一层
            //思路1：头结点层数为1，那么在添加左右子树时，把计数器1各加1，然后取数据时，计数器2再减1.
            //计数器2减为0时，即为一层结束.开始下一轮循环，设置计数器2=计数器1.
            //思路2：头结点层数为1，下一层的个数即为：每一层最右边的节点从队列取出后，队列的大小。（优选）
            //levelSize==0时，即取出了一层的最后一个数据
            list.add(temp.val);
            //一开始将2部分写在了这里，导致结果运行不对
            //因为此时，if中queue.size()还是0，需要等添加完左右子树后再计算队列大小

            if (temp.left != null) {
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }

            /**
             * 2
             */
            if (--levelSize == 0) {
                levelSize = queue.size();
                res.add(list);
                list = new ArrayList<>();
            }
        }

        return res;
    }
}
