class Solution {
    
    public boolean isOperator(String s){
        switch(s){
            case "+" : return true; 
            case "-" : return true;
            case "*" : return true;
            case "/" : return true;
        }
        return false;
    }
    
    public int applyOperator(int a,int b,String op){
        switch(op){
            case "+" : return a+b; 
            case "-" : return a-b;
            case "*" : return a*b;
            case "/" : return a/b;
        }
        return 0;
    }
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(isOperator(tokens[i])){
                String op2 = s.pop();
                String op1 = s.pop();
                int a = Integer.parseInt(op1);
                int b = Integer.parseInt(op2);
                int result = applyOperator(a,b,tokens[i]);
                s.push(String.valueOf(result));
            } else {
                s.push(tokens[i]);   
            }
        }
        int ans = Integer.parseInt(s.pop());
        return ans;
    }
}