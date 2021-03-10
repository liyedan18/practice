package binaryTree.p54;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 *
 * 思路：
 *      二叉搜索树，中序遍历是递增。
 *      第k大的节点也就是中序遍历倒数第k个节点
 */
public class Solution {
    List<Integer> list;

    public int kthLargest(TreeNode root, int k) {
        list = new ArrayList<>();
        traverse(root);
        return list.get(list.size() - k);
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }

    //迭代法中序遍历
    private void traverse2(TreeNode root) {
        if (root == null) {
            return;
        }

        //中序遍历框架，用栈
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode temp = stack.pop();
                list.add(temp.val);
                node = temp.right;
            }
        }
    }
}