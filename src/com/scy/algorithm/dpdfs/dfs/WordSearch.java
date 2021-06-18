package com.scy.algorithm.dpdfs.dfs;

/**
 * @desc: 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）79
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2020-09-13 21:13
 **/
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    //链接：https://leetcode-cn.com/problems/word-search/solution/hui-su-suan-fa-qiu-jie-by-sdwwld-2/
    private boolean dfs(char[][] board, char[] words, int i, int j,int index) {
        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || words[index] != board[i][j]) {
            return false;
        }
        //如果word的每个字符都查找完了，直接返回true
        if (index == words.length - 1) {
            return true;
        }

        //把当前坐标的值保存下来，为了在最后复原
        char tmp = board[i][j];
        //然后修改当前坐标的值
        board[i][j] = '.';
        //走递归，沿着当前坐标的上下左右4个方向查找
        boolean res = dfs(board, words, i + 1, j, index + 1) || dfs(board, words, i - 1, j, index + 1) ||
                dfs(board, words, i, j + 1, index + 1) || dfs(board, words, i, j - 1, index + 1);
        //递归之后再把当前的坐标复原
        board[i][j] = tmp;

        return res;
    }
}
