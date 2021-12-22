//Given two integers n and k, return all possible combinations of k numbers out 
//of the range [1, n]. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 799 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(n,k,1,res,cur);
        return res;

    }

    private void helper(int n, int k, int index, List<List<Integer>> res, List<Integer> cur){
        // record the answer
        if(cur.size() == k){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        // index=n+1 out
        if(index==n+1)
            return;

        // pick
        for(int i=index; i<=n;i++){
            // 终极剪枝
            if(cur.size()+n-i+1 < k)
                break;
            cur.add(i);
            helper(n, k, i+1, res,cur);
            cur.remove(cur.size()-1);
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
