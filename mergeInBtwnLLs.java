//https://leetcode.com/problems/merge-in-between-linked-lists/

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        //Tc: O(m+n)  Sc: O(1) 
        ListNode aCnct = null;
        ListNode bCnct = null;

        ListNode cur = list1;
        int ind = 0;
        while(cur != null)
        {
            if(ind == a-1) aCnct = cur;
            if(ind == b) bCnct = cur.next;
            cur = cur.next;
            ind++;
        }

        aCnct.next = list2;
        cur = list2;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = bCnct;

        return list1;
    }
}

