//Given two stings ransomNote and magazine, return true if ransomNote can be 
//constructed from magazine and false otherwise. 
//
// Each letter in magazine can only be used once in ransomNote. 
//
// 
// Example 1: 
// Input: ransomNote = "a", magazine = "b"
//Output: false
// Example 2: 
// Input: ransomNote = "aa", magazine = "ab"
//Output: false
// Example 3: 
// Input: ransomNote = "aa", magazine = "aab"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote and magazine consist of lowercase English letters. 
// 
// Related Topics 哈希表 字符串 计数 👍 256 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length())
            return false;
        int[] cnt = new int[26];
        for(char c: magazine.toCharArray())
            cnt[c-'a']++;

        for(char c: ransomNote.toCharArray()){
            cnt[c-'a']--;
            if(cnt[c-'a']<0)
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
