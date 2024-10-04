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


//In place
class Solution {
    //Tc: O(n) Sc: O(1) 
    public ListNode doubleIt(ListNode head) {
       if (head.val > 4) {
            head = new ListNode(0, head);
        }

        ListNode node = head;
        while (node != null) {
            node.val = (node.val * 2) % 10;  

            if (node.next != null && node.next.val > 4) {
                node.val++;  
            }
            
            node = node.next;  
        }
        
        return head;

        
    }
}



//Using a Stack
//Tc: O(n)  Sc: O(n) 
 Stack<ListNode> st = new Stack<>();
        ListNode cur = head;

        while(cur != null)
        {
            st.push(cur);
            cur = cur.next;
        }

        int carry = 0;
        while(!st.isEmpty())
        {
            cur = st.pop();
            int value = cur.val*2 + carry;
            cur.val = value%10;
            carry = value/10;
        }

        if(carry != 0)
        {
            ListNode res = new ListNode(carry);
            res.next = head;
            head = res;
        }
        return head;
    }
}


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
