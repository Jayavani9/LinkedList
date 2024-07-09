//https://www.geeksforgeeks.org/problems/remove-all-occurences-of-duplicates-in-a-linked-list/1?page=2&company=Microsoft&sortBy=latest

class Solution {
    public Node removeAllDuplicates(Node head) {
        // code here
        //Tc: O(n) Sc: O(1)
         Node dummy = new Node(0);
        dummy.next = head;
        
        Node pred = dummy;
        
        while (head != null) {

            if (head.next != null && head.data == head.next.data) {
         
                while (head.next != null && head.data == head.next.data) {
                    head = head.next;
                }

                pred.next = head.next; 
            } else { 
                pred = pred.next; 
            }
            head = head.next; 
        }
        
        return dummy.next;
    }
}

