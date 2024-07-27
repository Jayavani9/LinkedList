//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

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
    public ListNode swapNodes(ListNode head, int k) {
        //Tc: O(n) Sc: O(1) 
        int len = 0;
        ListNode cur = head;

        while(cur != null)
        {
            len++;
            cur = cur.next;
        }
        ListNode start = head;
        for(int i = 0; i < k-1; i++)
        {
            start = start.next;
        }
        ListNode end = head;
        for(int i = 0; i < len-k; i++)
        {
            end = end.next;
        }

        int temp = start.val;
        start.val = end.val;
        end.val = temp;
        return head;
    }
}
