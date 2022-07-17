class Solution {
    public int calculate(String s) {
        
        // get the number -- evaluate and dump it in stack
        Stack<Integer> st = new Stack<>();
        char sign = '+';
        
        for (int i = 0; i < s.length(); i++) {
            
           char c = s.charAt(i);
            
           if (c == ' ') continue;
           
           if (Character.isDigit(c)) {
               
               // get the entire digit at once and dump in the stack
               int val = 0;
               
               while (i < s.length() && Character.isDigit(s.charAt(i))) {
                   val = val * 10 + (s.charAt(i) - '0');
                   i++;
               }
               i--;
               
               if (sign == '+') {
                   st.add(val);
               } else if (sign == '-') {
                   st.add(-val);
               } else if (sign == '*') {
                   st.add(st.pop() * val);
               } else if (sign == '/') {
                   st.add(st.pop() / val);
               }
               
           } else {
               // char is not a digit
               sign = c;
               
           }
            
            
        }
        
        int result = 0;
        
        while (!st.isEmpty()) result += st.pop();
        
        return result;
    }
}