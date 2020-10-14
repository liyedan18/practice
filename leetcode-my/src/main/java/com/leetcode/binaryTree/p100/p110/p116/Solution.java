package com.leetcode.binaryTree.p100.p110.p116;


/**
 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

 struct Node {
 int val;
 Node *left;
 Node *right;
 Node *next;
 }
 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

 初始状态下，所有 next 指针都被设置为 NULL。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node


 思路：
 把每个节点的左子树都指向右子树

 一个参数已经不能解决了，那就再来一个参数
 把所有的（任意）相邻的左右节点都连起来。


 递归解决：
 1.明确方法的定义（相信方法的含义往下做，不要试图跳入循环。）
     ——这里可以根据定义的各种情况，判断出递归的停止条件
 2.确定方法参数的变量是什么
 3.拿到递归结果要干什么

 */

public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        connectTwo(root.left, root.right);
        return root;

    }

    private void connectTwo(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return;
        }

        /** 前序遍历位置 */
        root1.next = root2;

        // root1.left.next = root1.right;
        // root1.right.next = root2.left;
        // root2.left.next = root2.right;

        connectTwo(root1.left, root1.right);
        connectTwo(root1.right, root2.left);
        connectTwo(root2.left, root2.right);

    }

    //这样只是把同一个节点下的左右子树连起来了，不同节点的左右子树没法解决。
    // public Node connect(Node root) {
    //     if(root ==null){
    //         return null;
    //     }

    //     /** 前序遍历位置 */
    //     root.left.next = root.right;

    //     connect(root.left);
    //     connect(root.right);

    // }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}