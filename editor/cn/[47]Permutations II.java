//Given a collection of numbers, nums, that might contain duplicates, return 
//all possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 894 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> cur = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        helper(nums,res,cur,used);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res,Deque<Integer> cur, boolean[] used){
        if(cur.size()==nums.length){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i])
                continue;
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if(i>0 && nums[i]==nums[i-1] && used[i-1]==false)
                continue;

            cur.addLast(nums[i]);
            used[i] = true;
            helper(nums, res, cur, used);
            used[i] = false;
            cur.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
