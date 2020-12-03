package com.leetcode.binaryTree.p100.p100.p105;


import com.leetcode.binaryTree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 105. 从前序与中序遍历序列构造二叉树

 根据一棵树的前序遍历与中序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。

 例如，给出

 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 返回如下的二叉树：

 3
 / \
 9  20
 /  \
 15   7

 递归、迭代
 递归方法：
    先写出递归遍历框架
    确定方法的意义是，得到由前序与中序遍历序列构造的二叉树
    变量是前序和中序遍历
    根节点只需要把左右子树构造的二叉树拼接起来即可

    主要业务是确定左节点和右节点的前序和中序遍历
    自己写了如何从数据组获取指定元素的索引。—— 这里可以优化为用HashMap,只需遍历一次中序序列，不用每次获取根节点都去遍历。

 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || preorder.length == 0){
            return null;
        }

        //根节点
        TreeNode root = new TreeNode(preorder[0]);
        int inOrderRootIndex = getIndex(inorder, preorder[0]);
        //左子树的前序遍历和中序遍历
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, 1 + inOrderRootIndex);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, inOrderRootIndex);
        //右子树的前序遍历和中序遍历
        int[] rightPreOrder = Arrays.copyOfRange(preorder, inOrderRootIndex + 1, preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder, inOrderRootIndex + 1, inorder.length);

        //左子树的前序遍历和中序遍历
        root.left = buildTree(leftPreOrder, leftInOrder);
        //右子树的前序遍历和中序遍历
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
    }

    //存储中序遍历中的根节点，及对应的索引
    private static Map<Integer, Integer> map = new HashMap<>();
    static boolean  flag = true;
    private static int getIndex(int[] arr, int key){
        if (flag) {
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], i);
            }
        }

        return map.get(key);
    }
/*    private static int getIndex(int[] arr, int key){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key){
                return i;
            }
        }

        return -1;
    }*/

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] ints = {3, 9, 20, 15, 7};
        int[] ints1 = {9, 3, 15, 20, 7};
        s.buildTree(ints, ints1);
        // int i = Arrays.binarySearch(ints1, 7);  //得到索引,只能用于二叉搜索树
        // int i = Arrays.binarySearch(new int[]{6,12,36,85,46,96}, 12);  //得到索引
        // System.out.println(i);
        // int[] ints = Arrays.copyOfRange(new int[]{1, 2, 3, 4, 5, 6}, 0, 1);  //左开右闭
        // System.out.println(Arrays.toString(ints));
        // int[] ints1 = Arrays.copyOf(new int[]{1, 2, 3, 4, 5, 6}, 3);  //从index=0开始，截取3个元素
        // System.out.println(Arrays.toString(ints1));
    }
}
