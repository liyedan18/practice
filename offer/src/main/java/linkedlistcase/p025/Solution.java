package linkedlistcase.p025;


/**
 * 025   题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 *https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&&tqId=11178&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *
 * 这道题完全不知所云。直接看书上的思路。
 *
 * 思路：
 * 1.将链表每个节点在后面都复制一份，
 * A->B->C  变成了  A->A'->B->B'->C->C'
 *
 * 2.确定复制后链表节点的random指针位置。也就是原节点的下一个节点
 * 例：如果A->C  那么A'->C'
 *
 * 3.将整个链表分开，奇数位是原来的链表，偶数位是新链表。
 *
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
