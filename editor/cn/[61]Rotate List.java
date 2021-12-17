//Given the head of a linked list, rotate the list to the right by k places. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 500]. 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
// Related Topics 链表 双指针 👍 683 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null)
            return head;
        int num = 0;
        ListNode tail = null;
        ListNode p = head;
        // find the length and tail of the list
        while(p != null){
            tail = p;
            p = p.next;
            num++;
        }
        // decide the back length when k is too large
        k %= num;
        // find the last node after rotation ( the k+1 th node from the tail)
        p = head;
        for(int i = 0; i < num - k - 1; i++)
            p = p.next;
        // do the cut and join operation
        tail.next = head;
        head = p.next;
        p.next = null;

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
