class Solution {
    public int calculate(String s) {        
        // since this has () -> we need to use stack       
        s = s.trim();
        
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
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                // store result and sign into the stack -> we will use it later
                st.add(result);
                st.add(sign);
                
                // reset them
                result = 0;
                sign = 1;
                num = 0;
            } else if (c == ')') {
                
                result += sign * num;
                num = 0;
                sign = 1;
                
                // get the previous result and sign from the stack and merge it
                result *= st.pop();
                result += st.pop();
            }
         
            }
            // add final digit if there
            result += sign * num;
             return result;
        }
        
}