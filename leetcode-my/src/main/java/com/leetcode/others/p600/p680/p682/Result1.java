package com.leetcode.others.p600.p680.p682;


import java.util.ArrayList;
import java.util.List;

/**
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 * <p>
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 * 示例 2:
 * <p>
 * 输入: ["5","-2","4","C","D","9","+","+"]
 * 输出: 27
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到-2分。总数是：3。
 * 第3轮：你可以得到4分。总和是：7。
 * 操作1：第3轮的数据无效。总数是：3。
 * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
 * 第5轮：你可以得到9分。总数是：8。
 * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
 * 第7轮：你可以得到9 + 5 = 14分。总数是27。
 * 注意：
 * <p>
 * 输入列表的大小将介于1和1000之间。
 * 列表中的每个整数都将介于-30000和30000之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/baseball-game
 * <p>
 * 用List数据结构存储。
 * 注意：
 * 多运用List、map/stack数据结构
 */
public class Result1 {
    public int calPoints(String[] ops) {
        //根据实际情况，数组的index不会出现-2这样的越界情况
        //所以可以直接用list
        List<Integer> list = new ArrayList<>();
        int total=0;
        int lastIndex = 0;
        for (String s : ops) {
            lastIndex = list.size() - 1;
            switch (s) {
                case "C":
                    list.remove(lastIndex);
                    break;
                case "D":
                    list.add(list.get(lastIndex) * 2);
                    break;
                case "+":
                    list.add(list.get(lastIndex) + list.get(lastIndex - 1));
                    break;
                default:
                    list.add(Integer.parseInt(s));
            }
        }
        return list.stream().mapToInt(x->x).sum();

    }

    public static void main(String[] args) {
        Result1 result1 = new Result1();
        System.out.println(result1.calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(result1.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
