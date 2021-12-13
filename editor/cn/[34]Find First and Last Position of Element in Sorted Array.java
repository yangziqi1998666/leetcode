//Given an array of integers nums sorted in non-decreasing order, find the 
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1336 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        // 判断输入
        if ( nums == null || nums.length == 0){
            return res;
        }


        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 退出循环的时候，left = right+1
        // 而且 right = mid -1
        // 所以 mid = left
        if ( left >= nums.length || nums[left] != target){
            res[0] = -1;
        } else {
            res[0] = left;
        }

        // judge again
        if (res[0]==-1){
            return res;
        }

        // bound right
        right = nums.length-1;
        while(left<=right){
            int mid = (right-left)/2 + left;
            if(nums[mid]>target){
                right = mid -1;
            }
            if(nums[mid]<target){
                left = mid + 1;
            }
            if(nums[mid]==target){
                left = mid + 1;
            }
        }
        // 当循环结束的时候, left = right + 1
        // 同时 left = mid + 1
        // 如果 mid 是右边界的话
        // 那么, mid = left - 1 = right

        // 由于最左边界的查找,且经过判断,如果程序能到这,那一定存在target
        res[1] = right;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
