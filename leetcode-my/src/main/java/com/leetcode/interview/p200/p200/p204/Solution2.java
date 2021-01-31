package com.leetcode.interview.p200.p200.p204;

import java.util.HashMap;
import java.util.Map;

/**
 * 204. 计数质数
 *
 * 统计所有小于非负整数n的质数的数量。
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= n <= 5 * 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 *
 * 思路：
 *      质数：
 *          只能被自己和1整除
 *      用递归
 *          base case
 *              0  1  2
 *
 * 这种解法超出时间限制，需要优化
 *      对奇数和偶数做分别处理，只递归奇数
 *          这样还是会超出时间限制
 *
 *      加个备忘录试试
 *          此时，有stackoverflow错误
 *          不行
 */
public class Solution2 {

    //<n,有多少个质数>
    private Map<Integer, Integer> back;

    /**
     * 返回0- n-1的质数
     */
    public int countPrimes(int n) {
        if (n == 3) {
            return 1;
        }
        if (n <= 2) {
            return 0;
        }
        back = new HashMap<>();
        back.put(1, 0);
        back.put(0, 0);
        back.put(2, 1);
        back.put(3, 2);
        //判断n是否是偶数
        if (n % 2 == 0) {
            return count(n - 1);
        }
        return count(n - 2);
    }

    /**
     * 输入奇数，判断是否是质数
     */
    private int count(int n) {
        if (back.containsKey(n)) {
            return back.get(n);
        }

        int res = 0;
        res = count(n - 2);

        for (int i = 3; i <= n / 2; i += 2) {
            if (n % i == 0) {
                back.put(n, res);
                return res;
            }
        }

        res += 1;
        back.put(n, res);

        return res;
    }

}
