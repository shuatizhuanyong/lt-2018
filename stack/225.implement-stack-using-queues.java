class MyStack {

    Queue<Integer> q0 = new LinkedList<>();
    Queue<Integer> q1 = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q0.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q0.size() > 1) {
            q1.offer(q0.poll());
        }
        int val = q0.poll();
        while (q1.size() != 0) {
            q0.offer(q1.poll());
        }
        return val;
    }
    
    /** Get the top element. */
    public int top() {
        while (q0.size() > 1) {
            q1.offer(q0.poll());
        }
        int val = q0.peek();
        q1.offer(q0.poll());
        while (q1.size() != 0) {
            q0.offer(q1.poll());
        }
        return val;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q0.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
