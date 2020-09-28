package linkedlistcase.p055;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 055   给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&&tqId=11208&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 首先判断是否有环
 * 然后再看环的入口节点
 *
 * 思路2：
 * 遍历链表，把元素放入一个List或Set中，
 * 如果有重复的就返回该节点，说明有环形节点；
 * 如果没有重复的，就是没有环。
 *
 * 缺点：
 * 需要额外的空间来存储链表数据
 *
 */
public class Solution2 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        List<ListNode> list = new ArrayList<>();
//        Set<ListNode> list = new HashSet<>();
        while (!list.contains(pHead)) {
            list.add(pHead);
            pHead = pHead.next;
            if (pHead == null) {
                return null;
            }
        }

        return pHead;
    }

}
