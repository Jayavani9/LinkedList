19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
  
Example 2:
Input: head = [1], n = 1
Output: []
  
Example 3:
Input: head = [1,2], n = 1
Output: [1]

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

1. Two Pass solution
  
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Tc: O(n) Sc: O(1)
        int len = 0;
        ListNode first = head;
        while(first != null)
        {
            len++;
            first = first.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        len = len - n;
        first = dummy;
        while(len > 0)
        {
            len--;
            first = first.next;
        }

        first.next = first.next.next;
        return dummy.next;
        
    }
}


2. One pass solution
  
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Tc: O(L)  Sc: O(1)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode sec = dummy;

        for(int i = 1; i <= n+1; i++)
        {
            first = first.next;
        }

        while(first != null)
        {
            first = first.next;
            sec = sec.next;
        }
        sec.next = sec.next.next;
        return dummy.next;
    }
}
