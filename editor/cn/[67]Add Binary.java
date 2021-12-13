//Given two binary strings a and b, return their sum as a binary string. 
//
// 
// Example 1: 
// Input: a = "11", b = "1"
//Output: "100"
// Example 2: 
// Input: a = "1010", b = "1011"
//Output: "10101"
// 
// 
// Constraints: 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a and b consist only of '0' or '1' characters. 
// Each string does not contain leading zeros except for the zero itself. 
// 
// Related Topics 位运算 数学 字符串 模拟 👍 714 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int sum = 0;
        int carry = 0;
        for(int i = a.length()-1, j = b.length()-1; i>=0 || j>=0 || carry>0; i--,j--){
            sum = (i>=0?a.charAt(i)-'0':0)+(j>=0?b.charAt(j)-'0':0)+carry;
            res.append(sum%2);
            carry = sum/2;
        }
        return res.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
