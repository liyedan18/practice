package com.leetcode.interview.p800.p850.p855;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 855. 考场就座
 *
 * 在考场里，一排有N个座位，分别编号为0, 1, 2, ..., N-1。
 *
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 *
 * 返回ExamRoom(int N)类，它有两个公开的函数：其中，函数ExamRoom.seat()会返回一个int（整型数据），
 * 代表学生坐的位置；函数ExamRoom.leave(int p)代表坐在座位 p 上的学生现在离开了考场。
 * 每次调用ExamRoom.leave(p)时都保证有学生坐在座位p上。
 *
 * 示例：
 *
 * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * 输出：[null,0,9,4,2,null,5]
 * 解释：
 * ExamRoom(10) -> null
 * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
 * seat() -> 9，学生最后坐在 9 号座位上。
 * seat() -> 4，学生最后坐在 4 号座位上。
 * seat() -> 2，学生最后坐在 2 号座位上。
 * leave(4) -> null
 * seat() -> 5，学生最后坐在 5 号座位上。
 *
 *
 * 提示：
 *
 * 1 <= N <= 10^9
 * 在所有的测试样例中ExamRoom.seat()和ExamRoom.leave()最多被调用10^4次。
 * 保证在调用ExamRoom.leave(p)时有学生正坐在座位 p 上。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/exam-room
 *
 * 思路：
 *      如果把相邻的考生看做线段的两个端点，那新安排考生就是找最长的线段，然后将线段二分，考生坐在中间。
 *      考生离开，就是去除端点p，然后相邻的两个线段合二为一。
 *
 *      线段如何表示？
 *          用一位数组的2位表示线段两端即可。
 *
 *      找最长的线段，就是在动态过程中找最值，可以使用二叉搜索树TreeSet,底层是红黑树，有序。
 *
 *      1.要找索引最小的座位，先考虑找到最小的座位，不管索引
 *          完成增加，去除线段，计算线段长度
 *
 *          完成后，再优化最小的索引问题。
 *          如[0,4][4,9]，最长的线段是[4,9],则seat位置是(4+9)/2=6。
 *              其实不对,应该是(0+4)/2=2，虽然[4,9]更长，但他们中点的距离是相同的，需要优化TreeSet的比较逻辑。
 *              另外，比较起点到中点的距离更为合适。
 *                  如果距离相等，则再比较起始索引，索引小的要放在后面。
 *
 *      2.左右增加一个虚拟端点[-1,N]，就像链表的虚拟头结点一样，方便处理端点的情况
 *
 *      3.seat就是找出最长的线段，然后算出中点。然后更新线段
 *
 *      4.leave就是找出p左右两端的线段，然后合二为一。再更新线段
 *
 *      注意这里数据结构的用法
 *
 */
public class ExamRoom {

    //<端点p,以p为左端点的线段>
    private Map<Integer, int[]> pLeftMap;
    //<端点p,以p为右端点的线段>
    private Map<Integer, int[]> pRightMap;
    //所有线段，有序
    private TreeSet<int[]> pqAll;
    //考场总座位数
    private int N;

    public ExamRoom(int N) {
        this.N = N;
        pLeftMap = new HashMap<>();
        pRightMap = new HashMap<>();
        pqAll = new TreeSet<>((o1, o2) -> {
            int length1 = lengthOfLine(o1);
            int length2 = lengthOfLine(o2);
            //长度相同，则起始点索引小的排在前面
            if (length1 == length2) {
                return o2[0] - o1[0];
            }
            return length1 - length2;
        });
        // pqAll = new TreeSet<>(new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         return lengthOfLine(o1) - lengthOfLine(o2);
        //     }
        // });

        //增加虚拟端点
        pqAll.add(new int[]{-1, N});
    }

    public int seat() {
        //找出最长的线段
        int[] longestLine = pqAll.last();
        int left = longestLine[0];
        int right = longestLine[1];

        int position = 0;
        //边界情况时，会直接分配到边界位置
        if (left == -1) {
            position = 0;
        } else if (right == N) {
            position = N - 1;
        } else {
            position = (left + right) / 2;
        }

        //更新线段
        int[] newLeftLine = new int[]{left, position};
        int[] newRightLine = new int[]{position, right};
        pqAll.remove(longestLine);
        addLine(newLeftLine);
        addLine(newRightLine);

        return position;
    }

    public void leave(int p) {
        //找到p左右两端的线段
        int[] leftLine = pRightMap.get(p);
        int[] rightLine = pLeftMap.get(p);

        //合二为一
        int[] newLine = new int[]{leftLine[0], rightLine[1]};

        //更新线段
        removeLine(leftLine);
        removeLine(rightLine);
        addLine(newLine);
    }

    /**
     * 增加一个线段
     */
    private void addLine(int[] line) {
        pqAll.add(line);
        pLeftMap.put(line[0], line);
        pRightMap.put(line[1], line);
    }

    /**
     * 删除一个线段
     */
    private void removeLine(int[] line) {
        pqAll.remove(line);
        pLeftMap.remove(line[0]);
        pRightMap.remove(line[1]);
    }

    /**
     * 计算线段长度，优化后
     * 返回线段起点到中点的长度。
     */
    private int lengthOfLine(int[] line) {
        int left = line[0];
        int right = line[1];

        //边界情况时，会直接分配到边界位置，不会分配到中点
        if (left == -1) {
            // left = 0;
            return right;
        }
        if (right == N) {
            // right = N - 1;
            return N - 1 - left;
        }

        return (right + left) / 2 - left;
    }

    /**
     * 计算线段长度
     */
    private int lengthOfLine1(int[] line) {
        return line[1] - line[0];
    }

}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */