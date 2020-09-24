package stringcase.p044;


/**
 * 044 翻转句子单词顺序序列
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&&tqId=11197&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 思路1：
 *
 * 以空格分割，然后从前后两个方向对换位置。
 *
 * 注意：可以不用对换位置，分割之后，直接后序遍历输出。
 *
 */
public class Solution {

    public String reverseSentence(String str) {
        if (str == null || str.equals("")) {
            return str;
        }

        String[] tempStr = str.split(" ");
        if (tempStr.length <= 1) {
            return str;
        }
        StringBuilder strBuilder = new StringBuilder();
        for (int i = tempStr.length - 1; i >= 1; i--) {
            strBuilder.append(tempStr[i]);
            strBuilder.append(" ");
        }
        strBuilder.append(tempStr[0]);

        return strBuilder.toString();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseSentence("abcdefg"));
        System.out.println(solution.reverseSentence("student. a am I"));
    }

}
