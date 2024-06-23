//https://www.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class GFG{
	static void printList(Node node, PrintWriter out) 
	{ 
		while (node != null) 
		{ 
			out.print(node.data + " "); 
			node = node.next; 
		} 
		out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node ans = ob.divide(n, head);
            printList(ans, out); 
            t--;
        }
        out.flush();
    } 
} 
// } Driver Code Ends


//User function Template for Java

/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution{
    Node divide(int N, Node head){
        // code here
        //Tc: O(n) Sc: O(1) 
        Node cur = head;
        
        Node oddStart = null;
        Node evenStart = null;
        Node oddEnd = null;
        Node evenEnd = null;
        
        while(cur != null)
        {
            if(cur.data % 2 == 0)
            {
                if(evenStart == null)
                {
                    evenStart = cur;
                    evenEnd = evenStart;
                }
                else
                {
                    evenEnd.next = cur;
                    evenEnd = evenEnd.next;
                }
            }
            
            else 
            {
                 if(oddStart == null)
                {
                    oddStart = cur;
                    oddEnd = oddStart;
                }
                else
                {
                    oddEnd.next = cur;
                    oddEnd = oddEnd.next;
                }
                
            }
            cur = cur.next;
        }
        
        if(evenStart == null) return oddStart;
        if(oddStart == null) return evenStart;
        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }
}
