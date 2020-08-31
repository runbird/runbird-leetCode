package com.scy.algorithm.dynamicprogramming;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 类名： KeysAndRooms <br>
 * 描述：有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。
 * 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * 你可以自由地在房间之间来回走动。
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 示例 1：
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 *
 * 示例 2：
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 *
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 *
 * 来源：力扣（LeetCode）841
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/8/31 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class KeysAndRooms {

    /**
     * BFS
     * 使用广度优先搜索的方式遍历整张图，统计可以到达的节点个数，并利用数组 vis 标记当前节点是否访问过，以防止重复访问
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size(), num = 0;
        boolean[] vis = new boolean[size];
        vis[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            num++;
            if (num > size) return false;
            for (Integer x : rooms.get(cur)) {
                if (!vis[x]) {
                    vis[x] = true;
                    queue.offer(x);
                }
            }
        }
        return num == size;
    }

    /**
     * DFS
     * 使用深度优先搜索的方式遍历整张图，统计可以到达的节点个数，并利用数组 vis 标记当前节点是否访问过，以防止重复访问
     */
    boolean[] vis;
    int num;

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    private void dfs(List<List<Integer>> rooms, int cur) {
        vis[cur] = true;
        num++;
        for (Integer x : rooms.get(cur)) {
            if (!vis[x]) {
                dfs(rooms, x);
            }
        }
    }
}
