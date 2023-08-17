https://www.codingninjas.com/studio/problems/sort-linked-list-of-0s-1s-2s_1071937?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
    
     Node()
     {
         this.data = 0;
         this.next = null;
     }
    
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
    
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

 

public class Solution

{

    public static Node sortList(Node head) {

        // Write your code here

        // Node temp = head;

        if(head == null|| head.next == null){

            return head;

        }

 

        Node Mid = mid(head);

        Node nextOfMid = Mid.next;

        Mid.next = null;

        Node left = sortList(head);

        Node right = sortList(nextOfMid);

        Node sorted = mergesort(left,right);

        return sorted;

 

        

    }

    public static Node mergesort(Node left , Node right){

        Node temp = null;

        if(left== null){

            return right;

        }

        if(right == null){

            return left;

        }

        if(left.data< right.data){

            temp = left;

            temp.next = mergesort(left.next, right);

        }

        else{

            temp = right;

            temp.next = mergesort(left, right.next);

        }

        return temp;

    }

    public static Node mid(Node head){

        Node srtptr = head;

        Node fstptr = head;

        while(fstptr.next!=null && fstptr.next.next !=null){

            srtptr = srtptr.next;

            fstptr = fstptr.next.next;

 

        }

        return srtptr;

    }

}

