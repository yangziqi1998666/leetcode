//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics 哈希表 字符串 回溯 👍 1658 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        Map<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        helper(res, phoneMap, digits, 0, new StringBuilder());
        return res;
    }

    private void helper(List<String> res, Map<Character, String> phoneMap, String digits, int index, StringBuilder cur){
        if(index==digits.length()){
            res.add(cur.toString());
            return;
        }
        String letters = phoneMap.get(digits.charAt(index));
        for(int i=0; i<letters.length(); i++){
            cur.append(letters.charAt(i));
            helper(res,phoneMap,digits,index+1,cur);
            cur.deleteCharAt(index);
        }



    }
}
//leetcode submit region end(Prohibit modification and deletion)
