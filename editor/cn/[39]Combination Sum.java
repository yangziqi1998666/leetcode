//Given an array of distinct integers candidates and a target integer target, 
//return a list of all unique combinations of candidates where the chosen numbers 
//sum to target. You may return the combinations in any order. 
//
// The same number may be chosen from candidates an unlimited number of times. 
//Two combinations are unique if the frequency of at least one of the chosen 
//numbers is different. 
//
// It is guaranteed that the number of unique combinations that sum up to 
//target is less than 150 combinations for the given input. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple 
//times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
// 
//
// Example 3: 
//
// 
//Input: candidates = [2], target = 1
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// All elements of candidates are distinct. 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 👍 1672 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        helper(candidates, target, 0, result, curPath);
        return result;
    }


    private void helper(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> curPath){
        if(target==0){
            // curPath 是共享的,所以curPath要复制一份新的(地址)
            result.add(new ArrayList<Integer>(curPath));
            return;
        }

        for(int i=index; i<candidates.length; i++){
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }
            curPath.add(candidates[i]);
            helper(candidates,target-candidates[i],i,result,curPath);
            curPath.remove(curPath.size()-1);
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
