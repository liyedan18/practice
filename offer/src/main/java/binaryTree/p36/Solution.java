package binaryTree.p36;

import java.util.Stack;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 *
 *
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
 * 对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 *
 *
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，
 * 树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
 *
 * 思路：
 *
 *      二叉搜索树中序遍历，是递增序列。符合要求的排序特点。
 *      在中序遍历的同时，构造prev和cur节点
 *          如果prev=null，则是头结点head
 *          遍历完成后，prev就是尾结点，然后完善head和尾结点的关系即可。
 *
 *
 *      一开始想到求后继节点去了，想的太远了。
 *
 */
public class Solution {

    Node head;
    Node prev;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }

        head = null;
        prev = null;
        traverse(root);

        //完善头结点尾结点关系
        prev.right = head;
        head.left = prev;
        return head;
    }

    //递归中序遍历
    private void traverse(Node cur) {
        //结束遍历条件
        if (cur == null) {
            return;
        }

        traverse(cur.left);

        //中序遍历位置
        if (prev == null) {
            head = cur;
            prev = cur;
        } else {
            prev.right = cur;
            cur.left = prev;
            prev = cur;
        }

        traverse(cur.right);
    }

    //非递归法中序遍历
    private void traverseIterator(Node root) {

        Node temp = root;
        Stack<Node> stack = new Stack<>();
        // stack.push(cur);

        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                Node cur = stack.pop();

                //中序遍历处理
                if (prev == null) {
                    head = cur;
                    prev = cur;
                } else {
                    prev.right = cur;
                    cur.left = prev;
                    prev = cur;
                }

                temp = cur.right;
            }
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};