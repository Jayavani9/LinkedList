//https://www.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1?page=1&category%5B%5D=Linked%2520List&sortBy=

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class LinkedList_Element_From_Last {
    Node head;
    Node tail;

    /* Function to print linked list */
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    /* Drier program to test above functions */
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());

        while (t > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            LinkedList_Element_From_Last llist = new LinkedList_Element_From_Last();
            // int n=Integer.parseInt(br.readLine());
            s = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(s[i]);
                llist.addToTheLast(new Node(a));
            }

            // System.out.println(llist.head.data);
            Solution g = new Solution();
            // System.out.println(k);
            System.out.println(g.getKthFromLast(llist.head, k));

            t--;
        }
    }
}

// } Driver Code Ends


/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */

class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {
        // Your code here
        //Tc: O(n) Sc: O(1)
        int n = 0;
        Node cur = head;
        while(cur != null)
        {
            n++;
            cur = cur.next;
        }
        cur = head;
        int ans = -1;
        int req = n-k;
        if(req < 0) return -1;
        while(req > 0)
        {
            cur = cur.next;
            req--;
        }
        ans = cur.data;
        return ans;
    }
}
