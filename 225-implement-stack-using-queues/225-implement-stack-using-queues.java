class MyStack {

    ArrayList<Integer> s;
    public MyStack() {
        s = new ArrayList<>();
    }
    
    public void push(int x) {
        s.add(x);
    }
    
    public int pop() {
        if(!empty())
            return s.remove(s.size()-1);
        else 
            return -1;
    }
    
    public int top() {
        if(!empty())
            return s.get(s.size()-1);
        else return -1;
    }
    
    public boolean empty() {
        return s.isEmpty();
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