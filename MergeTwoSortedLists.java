21. Merge Two Sorted Lists
  
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Input: list1 = [], list2 = []
Output: []

Input: list1 = [], list2 = [0]
Output: [0]

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
    //Tc: O(m+n) and Sc: O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                cur.next = list1;
                list1 = list1.next;
            }
            else{
                cur.next = list2;
                list2= list2.next;
            }
            cur = cur.next;
        }
        if(list1 != null) cur.next = list1;
        else cur.next = list2;

        return ans.next;
}
}

