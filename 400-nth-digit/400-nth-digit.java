class Solution {
    public int findNthDigit(int n) {        
        long lower = 0;
        long upper = Integer.MAX_VALUE;
        
        while (lower < upper) {
            long middle = lower + ((upper - lower + 1) >> 1);
            
            if (getDigitsCount(middle) >= n) {
                upper = middle - 1;
            } else {
                lower = middle;
            }
        }
        
        long rest = n - getDigitsCount(lower);
        return findNthDigit(rest, lower + 1);
    }
    
    private long getDigitsCount(long n) {
        long answer = 0;
        long remainder = 0;
        long power = 1;
        
        while (n > 0) {
            answer += (n - 1) * power + (remainder + 1);
            remainder = remainder + (n % 10) * power;
            
            n /= 10;
            power *= 10;
        }
        
        return answer;
    }
    
    private int findNthDigit(long nth, long number) {
        Stack<Integer> stack = new Stack<>();
        while (number > 0) {
            stack.push((int) (number % 10));
            number /= 10;
        }
        
        while (nth > 1) {
            stack.pop();
            nth--;
        }
        
        return stack.pop();
    }
}