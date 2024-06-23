//https://www.geeksforgeeks.org/problems/intersection-of-two-linked-list/1?page=1&company%5B%5D=Amazon&category%5B%5D=Hash&sortBy=

//{ Driver Code Starts
//

import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        head = tail = new Node(val);
        
        size--;
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Solution obj = new Solution();
            
            Node result = obj.findIntersection(head1, head2);
            
            printList(result);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/* structure of list Node:

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

*/

class Solution
{
    public static Node findIntersection(Node head1, Node head2)
    {
        // add your code here
        // return the head of intersection list
        //Tc: O(m+n)  Sc: O(m+n)
        Set<Integer> set = new HashSet<>();
        Node cur2 = head2;
        
        // Add all elements of the second list to the set
        while (cur2 != null) {
            set.add(cur2.data);
            cur2 = cur2.next;
        }
        
        Node ansStart = null;
        Node ansEnd = null;
        Node cur1 = head1;
        zzzΩΩΩzz
        // Traverse the first list and create the intersection list
        while (cur1 != null) {
            if (set.contains(cur1.data)) {
                if (ansStart == null) {
                    ansStart = new Node(cur1.data);
                    ansEnd = ansStart;
                } else {
                    ansEnd.next = new Node(cur1.data);
                    ansEnd = ansEnd.next;
                }
            }
            cur1 = cur1.next;
        }
        
        return ansStart;
    }
}
