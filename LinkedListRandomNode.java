//https://leetcode.com/problems/linked-list-random-node/

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


//Using space 
class Solution {
    //Tc: O(n) Sc: O(n) 
    List<Integer> arr = new ArrayList<>();
    public Solution(ListNode head) {
        while(head != null)
        {
            arr.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        int cur = (int)(Math.random()*arr.size());
        return arr.get(cur);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
