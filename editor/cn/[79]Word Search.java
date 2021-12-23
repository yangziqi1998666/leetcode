//Given an m x n grid of characters board and a string word, return true if 
//word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, 
//where adjacent cells are horizontally or vertically neighboring. The same letter 
//cell may not be used more than once. 
//
// 
// Example 1: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board and word consists of only lowercase and uppercase English letters. 
// 
//
// 
// Follow up: Could you use search pruning to make your solution faster with a 
//larger board? 
// Related Topics 数组 回溯 矩阵 👍 1126 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        //使用记录
        boolean[][] used = new boolean[board.length][board[0].length];
        char[] words = word.toCharArray();
        for(int i=0;i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                used[i][j] = true;
                //如果返回的是true,则直接返回，反之则继续
                if(search(board,words,used,0,i,j))
                    return true;
                used[i][j] = false;
            }
        }
        return false;
    }

    private boolean search(char[][] board, char[] words, boolean[][] used, int index,int x, int y){
        //字符不相等 返回false
        if(board[x][y]!=words[index])
            return false;
        /**
         * 当下标 与 字符串长度 - 1 相等时，返回true.按照逻辑
         * 应该是前面的那个if条件满足后 else 中去判断的
         */
        if(index==words.length-1)
            return true;

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir : directions){
            int newx = x+dir[0];
            int newy = y+dir[1];
            if(newx>=0 &&newx <= board.length-1 && newy >=0 && newy<=board[0].length-1
                    && !used[newx][newy]){
                used[newx][newy]=true;
                if(search(board,words,used,index+1,newx,newy))
                    return true;
                used[newx][newy]=false;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
