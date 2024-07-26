//https://leetcode.com/problems/palindrome-linked-list/

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
    //Tc: O(N) Sc: O(1) 
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null)
        {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow);
        slow.next = null;
        while(rev != null)
        {
            if(head.val != rev.val) return false;
            head = head.next;
            rev = rev.next;

        }

        return true;
    }
}
