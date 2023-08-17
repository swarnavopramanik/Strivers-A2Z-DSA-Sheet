https://www.codingninjas.com/studio/problems/remove-duplicates-from-a-sorted-doubly-linked-list_2420283?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0


public class Solution {
    public static Node uniqueSortedList(Node head) {
        if(head == null){

           return head; 

        }

        Node temp = head;

        while(temp.next != null){

            if(temp.data == temp.next.data){

                Node node = temp.next.next;

                temp.next = node;

            }else{

                temp = temp.next;

            }

        }

        return head;
    }
}
