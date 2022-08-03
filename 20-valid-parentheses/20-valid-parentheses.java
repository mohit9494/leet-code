class Solution {
    public boolean isValid(String s) {
        
        if (s.length() % 2 != 0) return false;
        
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
          
            if (c == '(') st.add(')');
            else if (c == '[') st.add(']');
            else if (c == '{') st.add('}');
            else {
                if (st.isEmpty() || c != st.pop()) return false;
            }
            
        }
        
        return st.isEmpty();
    }
}