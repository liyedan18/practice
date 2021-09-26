package com.leetcode.backtrack.p000.p093;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 *
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 *
 */
public class Solution {

    List<String> res;

    public List<String> restoreIpAddresses(String s) {
        //字符串思路：一般是一个字符一个字符的处理
        //一个大问题，拆分成多个小问题，或是游戏等问题，考虑回溯算法（暴力求解）+剪枝

        //ip地址长度：4-12
        res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }

        backTrack(s, 0, new LinkedList<>(), 0);
        return res;
    }

    private void backTrack(String s, int index, LinkedList<String> singleRes, int curIpIndex) {
        //满足条件
        if (index == s.length() && singleRes.size() == 4) {
            // StringBuilder sb = new StringBuilder();
            // for (int i = 0; i < singleRes.size() - 1; i++) {
            //     sb.append(singleRes.get(i));
            //     sb.append(".");
            // }
            // sb.append(singleRes.getLast());
            // res.add(sb.toString());

            //以上代码替换为如下====>
            //注String.join的实现是和上面代码相同的
            res.add(String.join(".", singleRes));
            return;
        }
        //不满足条件（剪枝）,剩余字符串长度超过范围
        if (s.length() - index > (4 - curIpIndex) * 3) {
            return;
        }

        //遍历
        curIpIndex++;
        int ipNum = 0;
        for (int i = index; i < index + 3 && i < s.length(); i++) {
            //校验ip是否合法
            ipNum = ipNum * 10 + (s.charAt(i) - '0');
            if (i > index && ipNum < 10) {
                //以0为开头，则不符合要求
                return;
            }
            //ip地址超过范围
            if (ipNum < 0 || ipNum > 255) {
                return;
            }
            singleRes.add(String.valueOf(ipNum));
            backTrack(s, i + 1, singleRes, curIpIndex);
            singleRes.removeLast();
        }
    }
}
