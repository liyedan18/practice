package binaryTree.p07;

import binaryTree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 本题与主站 105 题重复
 *
 * 思路：
 *      找到根节点，递归构建左右子树
 *
 *      前序遍历第一个是根节点
 *      中序遍历以根节点为中线，左右两边分别是左右子树
 *
 *      优化：
 *          新建buildTree方法，不用Arrays.copyOfRange,在preorder和inorder中
 *          增加一个起始索引和结束索引
 *          且查询root.val在inorder中的索引用Map
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        TreeNode root = new TreeNode(preorder[0]);
        //根节点在中序遍历的索引
        int rootIndexOfInorder = getRootIndexOfInorder(root.val, inorder);
        //左子树节点个数
        int leftNodeNum = rootIndexOfInorder;
        //copyOfRange左闭右开区间
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + leftNodeNum),
                Arrays.copyOfRange(inorder, 0, rootIndexOfInorder));
        //右子树节点个数
        // int rightNodeNum = inorder.length - 1 - rootIndexOfInorder;
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + leftNodeNum, preorder.length),
                Arrays.copyOfRange(inorder, rootIndexOfInorder + 1, inorder.length));

        return root;
    }

    private int getRootIndexOfInorder(int val, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}