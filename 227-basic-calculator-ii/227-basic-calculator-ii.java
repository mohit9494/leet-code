class Solution {
    public int calculate(String s) {
        
        s = s.trim();
        
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char lastsign = '+';
        
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            
            if (c == ' ') continue;
            
            if (!Character.isDigit(c) || i == s.length() - 1) {
                
                if (lastsign == '+') {
                    st.add(num);
                } else if (lastsign == '-') {
                    st.add(-1 * num);
                } else if (lastsign == '*') {
                    st.add(st.pop() * num);
                } else if (lastsign == '/') {
                     st.add(st.pop() / num);
                }
                
              lastsign = c ;
              num = 0;
                
            }
        }
        
        int result = 0;
        while (!st.isEmpty()) {
            result += st.pop();
        }
        
        return result;
    }
}