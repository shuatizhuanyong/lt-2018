class MinStack {


    /** initialize your data structure here. */
    public MinStack() {

    }
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minst = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minst.isEmpty()) {
            minst.push(x);
            return;
        }
        int pkMin = minst.peek();
        if (x <= pkMin) {
            minst.push(x);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (minst.peek() == val) {
            minst.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minst.peek();
    }
}

4 , 6, 3, 2, 5
4, 3, 2

4, 6, 3, 2
4, 3, 2

4, 6, 3
4, 3

4, 6
4

4
4

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
