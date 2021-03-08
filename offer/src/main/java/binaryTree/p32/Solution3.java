package binaryTree.p32;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 *
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 *
 * 思路：
 *      其实就是二叉树的层序遍历,然后奇数正序，偶数倒序即可
 *      这里用一次遍历一层节点
 */
public class Solution3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //记录是奇数行还是偶数行
        int count = 0;

        while (!queue.isEmpty()) {
            int levelNodeSize = queue.size();
            List<Integer> singleRes = new ArrayList<>();

            for (int i = 0; i < levelNodeSize; i++) {
                TreeNode node = queue.poll();
                singleRes.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            //反转
            if ((count & 0x1) != 0) {
                Collections.reverse(singleRes);
            }
            count++;

            res.add(singleRes);

        }
        return res;
    }
}