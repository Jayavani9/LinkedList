23. Merge k Sorted Lists
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []

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

Solution: 

class Solution {
    //Tc: O(nlogn) and Sc: O(n)
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> result = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                result.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(result);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : result) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }
}
