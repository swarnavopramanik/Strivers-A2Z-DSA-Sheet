155. Min Stack


  class MinStack {
    private List<Integer> list = new ArrayList<>();
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        list.add(val);
        queue.add(val);
    }
    
    public void pop() {
        list.remove(list.size() - 1);
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        while (!list.contains(queue.peek())) queue.remove();
        return queue.peek();
    }
}
/**7
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
