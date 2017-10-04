class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> mins = new Stack<Integer>();
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if(mins.isEmpty() || x <= mins.peek()){
            mins.push(x);
        }
        
    }
    
    public void pop() {
        int top = stack.peek();
        stack.pop();
        if(top == (mins.peek())){
           mins.pop(); 
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
