class Solution {
    public int calculate(String s) {
        
        // very simple solution
        int result = 0;
        int num = 0;
        int sign = 1;
        
        // we will use 1 and -1 as a sign for + and  -
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            
         char c = s.charAt(i);
        
         if (Character.isDigit(c)) {
             num = num * 10 + (c - '0');
         } else if (c == '+'){
             result += sign * num;
             num = 0;
             sign = 1;
         } else if (c == '-') {
             result += sign * num;
             num = 0;
             sign = -1;
         } else if (c == '(') {
            // push all the result calculated till now to stack
            // push the sign as well - will be used later
            st.add(result);
            st.add(sign);
            result = 0;
            sign = 1;
         } else if (c == ')') {
             result += sign * num;
             
             // Get the sign 
             result *= st.pop();
             // total result
             result += st.pop();
             num = 0;
         }
            
            
        }
        
        // for last num
        result += sign * num;
        
        return result;
    }
}