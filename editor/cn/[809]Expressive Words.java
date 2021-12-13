//Sometimes people repeat letters to represent extra feeling. For example: 
//
// 
// "hello" -> "heeellooo" 
// "hi" -> "hiiii" 
// 
//
// In these strings like "heeellooo", we have groups of adjacent letters that 
//are all the same: "h", "eee", "ll", "ooo". 
//
// You are given a string s and an array of query strings words. A query word 
//is stretchy if it can be made to be equal to s by any number of applications of 
//the following extension operation: choose a group consisting of characters c, and 
//add some number of characters c to the group so that the size of the group is 
//three or more. 
//
// 
// For example, starting with "hello", we could do an extension on the group 
//"o" to get "hellooo", but we cannot get "helloo" since the group "oo" has a size 
//less than three. Also, we could do another extension like "ll" -> "lllll" to get 
//"helllllooo". If s = "helllllooo", then the query word "hello" would be stretchy 
//because of these two extension operations: query = "hello" -> "hellooo" -> 
//"helllllooo" = s. 
// 
//
// Return the number of query strings that are stretchy. 
//
// 
// Example 1: 
//
// 
//Input: s = "heeellooo", words = ["hello", "hi", "helo"]
//Output: 1
//Explanation: 
//We can extend "e" and "o" in the word "hello" to get "heeellooo".
//We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3
// or more.
// 
//
// Example 2: 
//
// 
//Input: s = "zzzzzyyyyy", words = ["zzyy","zy","zyy"]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, words.length <= 100 
// 1 <= words[i].length <= 100 
// s and words[i] consist of lowercase letters. 
// 
// Related Topics 数组 双指针 字符串 👍 51 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int expressiveWords(String s, String[] words) {
        // 用于统计符合条件的词语数量
        int count=0;

        for(String s_:words){
            // 左指针
            int left1=0,left2=0;
            // 右指针
            int right1=0,right2=0;
            boolean flag = true;

            while(right1<s.length() || right2<s_.length()){
                // 如果一个右指针越界, 则代表已经到尾部,让左指针保留不动
                // 这中情况发生在 类似于
                // abc    abcd
                left1 = right1<s.length()?right1:left1;
                left2 = right2<s_.length()?right2:left2;
                // 如果左指针位置处不等,则直接返回false
                if(s.charAt(left1)!=s_.charAt(left2)){
                    flag=false;
                    break;
                }

                // 右移指针到同一个字母的最右边
                while(right1<s.length() && s.charAt(left1)==s.charAt(right1)) right1++;
                while(right2<s_.length() && s_.charAt(left2)==s_.charAt(right2)) right2++;

                int dis1 = right1-left1;
                int dis2 = right2-left2;
                // 两种情况flag为true
                // dis1=dis2
                // dis1>dis2 && dis1>=3
                if(dis1>dis2 && dis1<3 || dis1<dis2)
                    flag = false;
            }
            if(flag)
                count++;
        }
        return count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
