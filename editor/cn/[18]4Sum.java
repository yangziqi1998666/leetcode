//Given an array nums of n integers, return an array of all the unique 
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 1042 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
最后执行的输入：
[0,0,0,1000000000,1000000000,1000000000,1000000000]
1000000000
越界
所以用
nums[a]+nums[a+1] > target-nums[a+2]-nums[a+3]
nums[a]+nums[size-3] < target-nums[size-1]-nums[size-2]
等等
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /*定义一个返回值*/
        List<List<Integer>> res = new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if(nums == null && nums.length < 4)
            return res;
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        int size = nums.length;
        /*定义4个指针a,b,c,d从0开始遍历，b从a+1开始遍历，留下c和d，c指向b+1，d指向数组最大值*/
        for(int a=0; a < size-3; a++){
            /*当a的值与前面的值相等时忽略*/
            if(a > 0 && nums[a] == nums[a-1])
                continue;
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            if(nums[a]+nums[a+1] > target-nums[a+2]-nums[a+3])
                break;
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            if(nums[a]+nums[size-3] < target-nums[size-1]-nums[size-2])
                continue;
            /*第二层循环b，初始值指向a+1*/
            for(int b=a+1; b < size-2; b++){
                /*当b的值与前面的值相等时忽略*/
                if(b > a+1 && nums[b] == nums[b-1])
                    continue;
                int c = b+1;
                int d = size-1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
                if(nums[a]+nums[b] > target-nums[c]-nums[c+1])
                    break;
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                if(nums[a]+nums[b] < target-nums[size-2]-nums[size-1])
                    continue;
                /*开始c指针和d指针的表演，计算当前和，如果等于目标值，c++并去重，d--并去重，当当前和大于目标值时d--，当当前和小于目标值时c++*/
                while(c < d){
                    if(nums[a]+nums[b]-target > -(nums[c]+nums[d]))
                        d--;
                    else if(nums[a]+nums[b]-target < -(nums[c]+nums[d]))
                        c++;
                    else{
                        res.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                        while(c<d && nums[c+1]==nums[c])
                            c++;
                        while(c<d && nums[d-1]==nums[d])
                            d--;
                        c++;
                        d--;
                    }
                }
            }
        }
        return res;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
