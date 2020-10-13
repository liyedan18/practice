package linkedlistcase.p056;


import java.util.ArrayList;
import java.util.List;

/**
 * 056   题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&&tqId=11209&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *
 * 思路1：
 * a  b   c
 * 遍历链表，把链表的值存入list，每次去list判断是否有这个值，有就删除
 * 遍历同时记录上一个节点a，和当前链表的下一个节点c，删除，即让b指向null，a指向c
 *
 * 可以把list换成set，这样更简便。不用判断list是否包含，直接存入set即可。
 *
 */
public class Solution {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        List<Integer> list = new ArrayList<>();
        List<Integer> listDel = new ArrayList<>();
        ListNode pre = pHead;
        ListNode res = pHead;
        ListNode tempNode;
        pHead = pHead.next;
        list.add(pHead.val);

        //下面这是完成了：链表1->2->3->3->4->4->5 处理后为{1,2,3,4,5}
        //要解决上面的问题，可以再增加一个list存放要删除的节点值。然后再遍历一次删除
        while (pHead != null) {
            if (list.contains(pHead.val)) {
                listDel.add(pHead.val);
                tempNode = pHead.next;
                pHead = pre;
                pHead.next = tempNode;
            } else {
                list.add(pHead.val);
            }
            pre = pHead;
            pHead = pHead.next;
        }

        //先删除头部
        while (res != null && listDel.contains(res.val)) {
            res = res.next;
        }
        if (res == null) {
            return res;
        }

        pHead = res;
        pre = pHead;
        while (pHead != null) {
            if (listDel.contains(pHead.val)) {
                tempNode = pHead.next;
                pHead = pre;
                pHead.next = tempNode;
            } else {
                pre = pHead;
                pHead = pHead.next;
            }
        }

        return res;

    }

}
