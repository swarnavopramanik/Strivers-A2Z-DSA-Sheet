https://www.codingninjas.com/studio/problems/stack-implementation-using-array_3210209?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class Solution{

    static class Stack {

        int arr[];

        int size,top;

        Stack(int capacity) {

            top=-1;

            this.size=capacity;

            arr=new int[capacity];

        }

        public void push(int num) {

            if(top==arr.length-1){

                return;

            }

            else{

                top++;

                arr[top]=num;

                return;

            }

        }

        public int pop() {

            if(top==-1){

                return -1;

            }

            else{

                int val=arr[top];

                top--;

                return val;

            }

        }

        public int top() {

             if (top == -1) {

                return -1;

            }

            return arr[top];

        }

        public int isEmpty() {

          if(top==-1){

              return 1;

          }

          return 0;

        }

        public int isFull() {

            if(top==arr.length-1){

                return 1;

            }

            return 0;

        }

    }

}
