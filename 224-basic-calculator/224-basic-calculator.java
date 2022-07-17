class Solution {
    public int calculate(String s) {

        int result = 0;
        int num = 0;
        int sign = 1;
        
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                st.add(result);
                st.add(sign);
                result = 0;
                sign = 1;              
            } else if (c == ')') {
                result += sign * num;
                sign = 1;
                num = 0;
                
                // use previous sign and result
                result *= st.pop();
                result += st.pop();
            }
            
        }
        
        // process final digit in expression
        result += sign * num;
        return result;
    }
}