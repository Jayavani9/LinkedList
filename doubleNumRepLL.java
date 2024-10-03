//https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/


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

//Using Reverse 
//Tc: O(n) Sc: O(1) 
class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode rev = reverse(head);
        int carry = 0;
        ListNode cur = rev;
        ListNode prev = null;

        while (cur != null) {
            int newVal = cur.val * 2 + carry; 
            cur.val = newVal % 10;            
            carry = newVal / 10;   
            prev = cur;
            cur = cur.next;
        }
        if (carry != 0) {
            ListNode tail = new ListNode(carry);
            prev.next = tail;
        }
        ListNode res = reverse(rev);
        return res;
    }

     public ListNode reverse(ListNode node) {
        ListNode prev = null, cur = node, Next;
        while (cur != null) {
            Next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = Next;
        }
        return prev;
    }
}
