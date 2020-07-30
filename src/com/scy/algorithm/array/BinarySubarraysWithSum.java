package com.scy.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名： BinarySubarraysWithSum <br>
 * 描述：在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。
 *
 * 示例：
 * 输入：A = [1,0,1,0,1], S = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1..]
 * [1,0,1,0]
 * [0,1,0,1]
 * [..1,0,1]
 *  
 *
 * 提示：
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] 为 0 或 1
 *
 * 来源：力扣（LeetCode）930
 * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/1/2 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class BinarySubarraysWithSum {
    // [1,0,1,0,1,0,0,1] s=2,则 索引为2和4 这段子区间的值符合
    // 2 的左侧有2种符合
    // 4 的右侧有三种符合
//    链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum/solution/he-xiang-tong-de-er-yuan-zi-shu-zu-by-leetcode/
    public int numSubarraysWithSum(int[] A, int S) {
        int su = 0;
        for (int x: A) su += x;

        // indexes[i] = location of i-th one (1 indexed)
        int[] indexes = new int[su + 2];
        int t = 0;
        indexes[t++] = -1;
        for (int i = 0; i < A.length; ++i)
            if (A[i] == 1)
                indexes[t++] = i;
        indexes[t] = A.length;

        int ans = 0;
        if (S == 0) {
            for (int i = 0; i < indexes.length - 1; ++i) {
                // w: number of zeros between consecutive ones
                int w = indexes[i+1] - indexes[i] - 1;
                ans += w * (w + 1) / 2;
            }
            return ans;
        }

        for (int i = 1; i < indexes.length - S; ++i) {
            int j = i + S - 1;
            int left = indexes[i] - indexes[i-1];
            int right = indexes[j+1] - indexes[j];
            ans += left * right;
        }

        return ans;
    }

    //方法二前缀和
    public int numSubarraysWithSum2(int[] A, int S) {
        int N = A.length;
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + A[i];

        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int x: P) {
            ans += count.getOrDefault(x, 0);
            count.put(x+S, count.getOrDefault(x+S, 0) + 1);
        }

        return ans;
    }

    public int numSubarraysWithSum3(int[] A, int S) {
        int iLo = 0, iHi = 0;
        int sumLo = 0, sumHi = 0;
        int ans = 0;

        for (int j = 0; j < A.length; ++j) {
            // While sumLo is too big, iLo++
            sumLo += A[j];
            while (iLo < j && sumLo > S)
                sumLo -= A[iLo++];

            // While sumHi is too big, or equal and we can move, iHi++
            sumHi += A[j];
            while (iHi < j && (sumHi > S || sumHi == S && A[iHi] == 0))
                sumHi -= A[iHi++];

            if (sumLo == S)
                ans += iHi - iLo + 1;
        }

        return ans;
    }

    //前缀和法
    //F[i] = A[0]+....+A[i-1]
    //F[j+1] - F[i] = A[i] + ... A[j]
    public int test(int[] A, int S) {
        int length = A.length;
        int[] F = new int[length + 1];
        for (int i = 0; i < length; i++) {
            F[i + 1] = F[i] + A[i];
        }
        Map<Integer, Integer> dict = new HashMap<>();
        int ans = 0;
        for (int x : F) {
            ans += dict.getOrDefault(x, 0);
            dict.put(x + S, dict.getOrDefault(x + S,0) + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] A = new int[]{1,0,1,0,1};
        int S = 2;
        System.out.println(new BinarySubarraysWithSum().test(A,S));
    }
}
