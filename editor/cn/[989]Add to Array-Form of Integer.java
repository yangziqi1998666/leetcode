//The array-form of an integer num is an array representing its digits in left 
//to right order. 
//
// 
// For example, for num = 1321, the array form is [1,3,2,1]. 
// 
//
// Given num, the array-form of an integer, and an integer k, return the array-
//form of the integer num + k. 
//
// 
// Example 1: 
//
// 
//Input: num = [1,2,0,0], k = 34
//Output: [1,2,3,4]
//Explanation: 1200 + 34 = 1234
// 
//
// Example 2: 
//
// 
//Input: num = [2,7,4], k = 181
//Output: [4,5,5]
//Explanation: 274 + 181 = 455
// 
//
// Example 3: 
//
// 
//Input: num = [2,1,5], k = 806
//Output: [1,0,2,1]
//Explanation: 215 + 806 = 1021
// 
//
// Example 4: 
//
// 
//Input: num = [9,9,9,9,9,9,9,9,9,9], k = 1
//Output: [1,0,0,0,0,0,0,0,0,0,0]
//Explanation: 9999999999 + 1 = 10000000000
// 
//
// 
// Constraints: 
//
// 
// 1 <= num.length <= 10⁴ 
// 0 <= num[i] <= 9 
// num does not contain any leading zeros except for the zero itself. 
// 1 <= k <= 10⁴ 
// 
// Related Topics 数组 数学 👍 177 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        List<Integer> res = new ArrayList<>();
        int i = n-1;
        int sum = 0;
        int carry = 0;

        while(i>=0 || k!=0 || carry>0){
            // 当前位
            int x = i >= 0 ? num[i] : 0;
            int y = k != 0 ? k%10 : 0;
            // 求和
            sum = x + y + carry;
            // 对当前位进行操作
            carry = sum/10;
            k = k/10;
            i--;
            // 加入res
            res.add(sum%10);
        }

        // 翻转
        Collections.reverse(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
