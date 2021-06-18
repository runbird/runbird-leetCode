package com.scy.algorithm.dpdfs.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名： RobotReturnToOrigin <br>
 * 描述：在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
 * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
 *
 * 示例 1:
 * 输入: "UD"
 * 输出: true
 * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
 *
 * 示例 2:
 * 输入: "LL"
 * 输出: false
 * 解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
 *
 * 来源：力扣（LeetCode）657
 * 链接：https://leetcode-cn.com/problems/robot-return-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/8/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class RobotReturnToOrigin {
    private int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private char[] flag = {'U', 'D', 'L', 'R'};

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) return true;
        Map<Character, int[]> map = new HashMap<>(4);
        for (int i = 0; i < 4; i++) {
            map.put(flag[i], dir[i]);
        }
        char[] chars = moves.toCharArray();
        int[] ans = {0, 0};
        for (char c : chars) {
            int[] cur = map.get(c);
            ans[0] += cur[0];
            ans[1] += cur[1];
        }
        return ans[0] == 0 && ans[1] == 0;
    }

    public boolean judgeCircle2(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                x++;
            } else if (c == 'D') {
                x--;
            } else if (c == 'L') {
                y--;
            } else if (c == 'R') {
                y++;
            }
        }
        return x == 0 && y == 0;
    }


        public static void main(String[] args) {
        String moves = "LL";
        RobotReturnToOrigin origin = new RobotReturnToOrigin();
        System.out.println(origin.judgeCircle(moves));
    }
}
