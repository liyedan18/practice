package com.leetcode.p800.p840.p849;


import java.util.Arrays;

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

 只需找到最大距离
 两边和中间的距离单独计算
 两边：数字到边界的距离
 中间：分段

 */
public class Result1 {
    public int maxDistToClosest(int[] seats) {
        //先转换为字符串
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(seats).forEach(value -> stringBuilder.append(value));
        //等同于
//        Arrays.stream(seats).forEach(stringBuilder::append);

        //计算分段最大值（）
        int maxSegment = Arrays.stream(stringBuilder.toString().split("1"))  //可以是.split("[1]+")
                .mapToInt(String::length)
                .max()
                .getAsInt();
        //所有分段的最大距离。如果在边上，则最大距离已经减半了
        int maxDistance = (maxSegment + 1) / 2;
        //算出边上的距离，然后对比
        int leftMaxDistance = stringBuilder.toString().indexOf("1");
        int rightMaxDistance = stringBuilder.length() - 1 - stringBuilder.toString().lastIndexOf("1");

        return Math.max(maxDistance, Math.max(leftMaxDistance, rightMaxDistance));

    }

    public static void main(String[] args) {
        Result1 result1 = new Result1();
//        int[] seats = {1,0,0,0,1,0,1};
        int[] seats = {1,0,0,0};
        System.out.println(result1.maxDistToClosest(seats));

    }
}
