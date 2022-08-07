class Solution {
    public int evalRPN(String[] tokens) {
        
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        
        Stack<Integer> st = new Stack<>();
        
        for (String s : tokens) {
            
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                // op
                int result = 0;
                int second = st.pop();
                int first = st.pop();
                if (s.equals("+")) {
                    result = first + second;
                } else if (s.equals("-")) {
                    result = first - second;
                } else if (s.equals("*")) {
                    result = first * second;
                } else if (s.equals("/")) {
                    result = first / second;
                }
                st.push(result);
            } else {
                st.add(Integer.parseInt(s));
            }            
            
        }
        
        return st.peek();
        
    }
}