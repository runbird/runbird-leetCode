package com.scy.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： CombinationSumIII <br>
 * 描述：216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]] <br>
 * 创建日期： 2020/9/11 <br>
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * @author suocaiyuan
 * @version V1.0
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
        //终止条件，找到一组合适的
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        //注意这里，因为不能有重复的集合以及集合中不能有重复的数字，所以这里的i不能从0开始，
        // 要从上一个选择之后的下一个值开始
        for (int i = start; i <= 9; i++) {
            //选择当前值
            list.add(i);
            //递归
            dfs(res, list, k, i + 1, n - i);
            //撤销选择
            list.remove(list.size() - 1);
        }
    }
}
