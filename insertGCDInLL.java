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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        //Tc: O(n*log(min(n1,n2)) Sc: O(1)
        if(head.next == null) return head;

        ListNode firstNode = head;
        ListNode secNode = head.next;

        while(secNode != null)
        {
            int gcd = calcGCD(firstNode.val, secNode.val);
            ListNode nodeGCD = new ListNode(gcd);
            firstNode.next = nodeGCD;
            nodeGCD.next = secNode;

            firstNode = secNode;
            secNode = secNode.next;
        }

        return head;
    }

    private int calcGCD(int n1, int n2)
    {
        while(n2 != 0)
        {
            int temp = n2;
            n2 = n1%n2;
            n1 = temp;
        }
        return n1;
    }
}
