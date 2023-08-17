https://www.codingninjas.com/studio/problems/flatten-a-linked-list_1112655?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

public class Solution {

    public static Node flattenLinkedList(Node head) {

        //Write your code here

        if(head==null || head.next==null) return head;

 

        Node ans=head;

        Node temp=head.next;

        ans.next=null;

        

        while(temp!=null){

            ans=mergeTwoLists(ans, temp);

            temp=temp.next;

        }

        

        return ans;

    }

 

    public static Node mergeTwoLists(Node a, Node b) {

        

        Node temp = new Node(0);

        Node res = temp; 

        

        while(a != null && b != null) {

            if(a.data < b.data) {

                temp.child = a; 

                temp = temp.child; 

                a = a.child; 

            }

            else {

                temp.child = b;

                temp = temp.child; 

                b = b.child; 

            }

        }

        

        if(a != null) temp.child = a; 

        else temp.child = b;

        return res.child; 

    

    }

}
