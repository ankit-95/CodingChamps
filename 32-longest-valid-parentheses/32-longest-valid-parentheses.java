class Solution {
    public int longestValidParentheses(String s) {
        if (s==null||s.length()==0) return 0;
		
		Stack<Integer> stack= new Stack<Integer>();	//Store indices of '('
		int[] result=new int[s.length()];//Store the length of the current longest valid sequence.
		Arrays.fill(result, 0);
		
		int max=0;
		
		for (int i=0;i<s.length();i++)
			if (s.charAt(i)=='(')
				stack.push(i);	
									
			else if (s.charAt(i)==')'){
				if (stack.isEmpty()) 
					continue;
				else if (stack.peek()>0) 
					result[i]=2+result[stack.pop()-1]+result[i-1];//May connect two valid sequences, or increase the length of current valid sequence. 
				else {
					result[i]=2+result[i-1];//Handle the special case that the leftmost char is a '('
					stack.pop();
				}
				
				max=Math.max(result[i],max);
			}
		return max;
    }
}