class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(val);
            minSt.push(val);
        } else {
            st.push(val);
            if(minSt.peek() > val){
                minSt.push(val);
            } else {
                minSt.push(minSt.peek());
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty())
            return;   
        st.pop();
        minSt.pop();
    }
    
    public int top() {
        if(st.isEmpty())
            return -1;
        return st.peek();
    }
    
    public int getMin() {
        if(minSt.isEmpty())
            return -1;
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */