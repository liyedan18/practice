package com.leetcode.p800.p840.p849;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。

 至少有一个空座位，且至少有一人坐在座位上。

 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。

 返回他到离他最近的人的最大距离。

 示例 1：

 输入：[1,0,0,0,1,0,1]
 输出：2
 解释：
 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 因此，他到离他最近的人的最大距离是 2 。
 示例 2：

 输入：[1,0,0,0]
 输出：3
 解释：
 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 这是可能的最大距离，所以答案是 3 。

 提示：

 2 <= seats.length <= 20000
 seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximize-distance-to-closest-person

 最大距离=2个有人座位的距离/2
 或
 1个座位到没有人边上的最大距离

 直接遍历计算
 遇到1开始计算距离
 最后的0另外计算

 */
public class Result2 {
    public int maxDistToClosest(int[] seats) {
        //1的位置
        int prev = -1;
        int max = 0;
        for (int i = 0; i < seats.length; i++) {
            //遇到1才开始计算距离
            if (seats[i] == 1) {
                //前面已经有1
                if (prev >= 0) {
                    max = Math.max(max, (i -prev)/2);
                } else {
                    max = i;
                }
                prev = i;
            }
        }

        //计算最后的0
        int rightMax = seats.length - 1 - prev;
        return Math.max(max, rightMax);

    }

    public static void main(String[] args) {
        Result2 result1 = new Result2();
        int[] seats = {1,0,0,0,1,0,1};
//        int[] seats = {1,0,0,0};
        System.out.println(result1.maxDistToClosest(seats));

        Map<String,String> map = new HashMap<>();
        map.put("1","22");
        map.forEach((s, s2) -> System.out.println(s +"==="+s2));
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        Runnable runnable1 = ()->{
            System.out.println("a新县城");
        };
        new Thread(runnable1).start();
    }
}
