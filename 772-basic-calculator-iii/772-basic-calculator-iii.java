class Solution {
    
    class Pair {
        
        Stack<Integer> resultStack;
        char sign;
        
        Pair(Stack<Integer> resultStack, char sign) {
            this.resultStack = resultStack;
            this.sign = sign;
        }
        
    }
    
    public void cal(Stack<Integer> st, int val, char sign) {
        
        if (sign == '+') {
                st.add(val);
            } else if (sign == '-') {
                st.add(-val);
            } else if (sign == '*') {
                st.add(st.pop() * val);
            }
            else if (sign == '/') {
                st.add(st.pop() / val);
            }
    }
    
    public int calculate(String s) {
        
        //based on Calculator 2;
        // Here we have both the () and * /

        Stack<Integer> st = new Stack<>();
        Stack<Pair> stp = new Stack<>();
        char sign = '+';
        
        for (int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            if (c == ' ') continue;
            
            if (Character.isDigit(c)) {
                int val = 0;
                // Get the digit at once and dump it in stack
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                
                cal(st, val, sign);
                
            } else if (c == '(') {
            // get the earlier stack and sign and dump it the stack

                stp.add(new Pair(st, sign));
                
                st = new Stack<>();
                sign = '+';
                
            } else  if (c == ')') {
                
                // calculate the result1 of inner bracket 
                int temp = 0;
                while (!st.isEmpty()) temp += st.pop();
                
                // merge with the previous result
                Pair pair = stp.pop();
                sign = pair.sign;
                st = pair.resultStack;
                
                cal(st, temp, sign);
                
            } else {
                sign = c;
            }
    
        }
        
        int result = 0;
        
        while (!st.isEmpty()) result += st.pop();
        
        return result;
        
    }
}