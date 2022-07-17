class Solution {
    public int calculate(String s) {
        
        s = s.trim();
        
        Stack<Integer> st = new Stack<>();
        char lastsign = '+';
        
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            // If digit calculate it on the one go and deal with it immediately
            
            if (Character.isDigit(c)) {
                int num = 0;               
                while ( i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                
                // lets see what to do with this val
                if (lastsign == '+') {
                    st.add(num);
                } else if (lastsign == '-') {
                    st.add(-num);
                } else if (lastsign == '*') {
                    st.add(st.pop() * num);
                } else if (lastsign == '/') {
                    st.add(st.pop() / num);
                }
                
            } else if (c != ' ') {
               lastsign = c; 
            }            

        }
        
        int result = 0;
        while (!st.isEmpty()) {
            result += st.pop();
        }
        
        return result;
    }
}