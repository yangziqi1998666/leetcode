//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the 
//Fibonacci sequence, such that each number is the sum of the two preceding ones, 
//starting from 0 and 1. That is, 
//
// 
//F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2), for n > 1.
// 
//
// Given n, calculate F(n). 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// Example 3: 
//
// 
//Input: n = 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 372 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        if(n<1) return 0;
        // 备忘录全初始化为 0
        int[] memo = new int[n+1];
        // 进行带备忘录的递归
        return helper(memo,n);
    }

    private int helper(int[] memo, int n){
        // base case
        if(n==1||n==2)
            return 1;
        // 已经计算过
        if(memo[n]!=0)
            return memo[n];
        memo[n] = helper(memo,n-1)+helper(memo,n-2);
        return memo[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
