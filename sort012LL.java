//https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1?page=2&category%5B%5D=Linked%2520List&sortBy=

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Driverclass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }

    public static void printList(Node head, PrintWriter out) {
        if (head == null) return;

        Node temp = head;
        while (temp != null) {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        //Tc: O(n)  Sc: O(1)
        // add your code here
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        
        Node cur = head;
        
        while(cur != null)
        {
            if(cur.data == 0) c0++;
            else if(cur.data == 1) c1++;
            else if(cur.data == 2) c2++;
            cur = cur.next;
        }
        
        cur = head;
        while (c0 > 0) {
            cur.data = 0;
            cur = cur.next;
            c0--;
        }
        while (c1 > 0) {
            cur.data = 1;
            cur = cur.next;
            c1--;
        }
        while (c2 > 0) {
            cur.data = 2;
            cur = cur.next;
            c2--;
        }
        
        return head;
        
        
    }
}
