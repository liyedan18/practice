package binaryTree.p55;

import binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 *
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度3 。
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * 注意：本题与主站 104题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 *
 * 思路：
 *      二叉树层序遍历
 *      或者递归
 */
public class Solution {
    /**
     * 层序遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelNodeSize = queue.size();

            for (int i = 0; i < levelNodeSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            depth++;
        }

        return depth;
    }

    /**
     * 递归
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return res;
    }
}
