20. Valid Parentheses


   class Solution {
 
    boolean valid(char b, char e) {
return b == '(' && e == ')' || b == '{' && e == '}' || b == '[' && e == ']';
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (valid(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();  
    } 
} 
