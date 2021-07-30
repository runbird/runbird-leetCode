package com.scy.algorithm.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 类名： MinimumNumberOfRefuelingStops <br>
 * 描述：汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 * 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 * <p>
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 * <p>
 * 示例 1：
 * 输入：target = 1, startFuel = 1, stations = []
 * 输出：0
 * 解释：我们可以在不加油的情况下到达目的地。
 * <p>
 * 示例 2：
 * 输入：target = 100, startFuel = 1, stations = [[10,100]]
 * 输出：-1
 * 解释：我们无法抵达目的地，甚至无法到达第一个加油站。
 * <p>
 * 示例 3：
 * 输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * 输出：2
 * 解释：
 * 我们出发时有 10 升燃料。
 * 我们开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
 * 然后，我们从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
 * 并将汽油从 10 升加到 50 升。然后我们开车抵达目的地。
 * 我们沿途在1两个加油站停靠，所以返回 2 。
 * <p>
 * 来源：力扣（LeetCode）871. 最低加油次数
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-refueling-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/7/26 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int len = stations == null ? 0 : stations.length;
        //当前位置  索引  剩余油量  加油次数
        int curPos = 0, index = 0, fuelLeft = startFuel, fuelTime = 0;
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        while (curPos + fuelLeft < target) {
            // 默认期望的下一站，站点设置为target 此时能加的汽油为0
            int exceptPos = target, fuel = 0;
            if (index < len && stations[index][0] <= target) {
                exceptPos = stations[index][0];
                fuel = stations[index][1];
            }

            //如果不能到达期望的下一站
            while (curPos + fuelLeft < exceptPos) {
                //检测是否有存量油
                if (queue.isEmpty()) {
                    return -1;
                }
                int curMaxFuel = queue.poll();
                fuelLeft += curMaxFuel;
                fuelTime++;
            }
            //计算消耗掉的油
            int fuelCost = exceptPos - curPos;
            fuelLeft -= fuelCost;
            curPos = exceptPos;
            if (fuel > 0) {
                queue.offer(fuel);
            }
            index++;
        }
        return curPos + fuelLeft >= target ? fuelTime : -1;
    }
}