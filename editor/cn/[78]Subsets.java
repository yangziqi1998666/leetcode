//Given an integer array nums of unique elements, return all possible subsets (
//the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
// Related Topics 位运算 数组 回溯 👍 1425 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(nums,res,cur,0);
        return res;
    }

    private void helper(int[] nums,List<List<Integer>> res,List<Integer> cur,int index){
        res.add(new ArrayList<Integer>(cur));
        for(int i=index;i<nums.length; i++){
            cur.add(nums[i]);
            helper(nums,res,cur,i+1);
            cur.remove(cur.size()-1);
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
