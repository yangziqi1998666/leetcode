//Given a collection of candidate numbers (candidates) and a target number (
//target), find all unique combinations in candidates where the candidate numbers sum 
//to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: The solution set must not contain duplicate combinations. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 772 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates==null || candidates.length==0)
            return res;
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,0,res,cur);
        return res;
    }

    private void helper(int[] candidates, int target,int index, List<List<Integer>> res,List<Integer> cur){
        if(target==0){
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i=index; i<candidates.length; i++){
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if(target-candidates[i]<0)
                break;
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            cur.add(candidates[i]);
            helper(candidates,target-candidates[i],i+1,res,cur);
            cur.remove(cur.size()-1);
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
