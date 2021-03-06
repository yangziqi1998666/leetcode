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
// Related Topics æ°ç» åæº¯ ð 772 ð 0


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
            // å¤§åªæï¼åå» candidates[i] å°äº 0ï¼åå»åé¢ç candidates[i + 1]ãcandidates[i + 2] è¯å®ä¹å°äº 0ï¼å æ­¤ç¨ break
            if(target-candidates[i]<0)
                break;
            // å°åªæï¼åä¸å±ç¸åæ°å¼çç»ç¹ï¼ä»ç¬¬ 2 ä¸ªå¼å§ï¼åéæ°æ´å°ï¼ç»æä¸å®åçéå¤ï¼å æ­¤è·³è¿ï¼ç¨ continue
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
