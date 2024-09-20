//https://leetcode.com/problems/remove-nodes-from-linked-list/description/

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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode cur = head;

        while(cur != null)
        {
            st.push(cur);
            cur = cur.next;
        }

        cur = st.pop();
        int max = cur.val;
        ListNode res = new ListNode(max);

        while(!st.isEmpty())
        {
            cur = st.pop();
            if(cur.val < max)
            {
                continue;
            }

            else 
            {
                ListNode newNode = new ListNode(cur.val);
                newNode.next = res;
                res = newNode;
                max = cur.val;
            }
        }

        return res;
    }
}
