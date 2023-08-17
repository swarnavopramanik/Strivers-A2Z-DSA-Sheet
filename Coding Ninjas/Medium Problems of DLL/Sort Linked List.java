https://www.codingninjas.com/studio/problems/sort-linked-list_625193?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

public class Solution {

   public static Node sortList(Node head) {

        if (head == null || head.next == null) {

            return head;

        }

        Node mid = getMid(head);

        Node nextOfMid = mid.next;

        mid.next = null;

        Node left = sortList(head);

        Node right = sortList(nextOfMid);

        Node sortedList = mergeSort(left, right);

        return sortedList;

    }

    

    public static Node mergeSort(Node left, Node right) {

        Node result = null;

        if (left == null) {

            return right;

        }

        if (right == null) {

            return left;

        }

        if (left.data < right.data) {  // Replace 'val' with 'data'

            result = left;

            result.next = mergeSort(left.next, right);

        } else {

            result = right;

            result.next = mergeSort(left, right.next);

        }

        return result;

    }

    

    public static Node getMid(Node head) {

        if (head == null) {

            return head;

        }

        Node slow = head;

        Node fast = head;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;

            fast = fast.next.next;   

        }        

        return slow;

    }

    

}    
