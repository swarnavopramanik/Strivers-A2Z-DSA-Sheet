232. Implement Queue using Stacks

//This is insert efficient, Inserting element into queue will take O(1) time
//But removing an element will take O(n) time as it has to traverse the whole stack.

  
  class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();

    }
    
    public void push(int x) {
        first.push(x);         //O(1)
    }
    
    public int pop() {    //O(n)
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int removed = second.pop();
        while(!second.isEmpty()){
            first.push(second.pop());
        }

        return removed;
    }
    
    public int peek() {              //O(n)
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int peeked = second.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }

        return peeked;
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}



//==============================SECOND-CODE=============================

//This is remove efficient.

/* class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();

    }
    
    public void push(int x) {    //O(n)
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        first.push(x);
        while(!first.isEmpty()){
            second.push(first.pop());
        }
    }
    
    public int pop() {    //O(1)
        int removed = second.pop();
        return removed;

        
    }
    
    public int peek() {   //O(1)
        int peeked = second.peek();
        return peeked;
    }
    
    public boolean empty() {
        return second.isEmpty();
    }
}
 */
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
