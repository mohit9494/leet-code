class Solution {
    public boolean isValid(String s) {
        
      Stack<Character> st = new Stack();
       
      for (int i = 0; i < s.length(); i++) {
          
          char c =  s.charAt(i);
          
          if (c == '(') st.add(')');
          else if (c == '[') st.add(']');
          else if (c == '{') st.add('}');
          else {
             if (st.isEmpty()) {
                 return false;
             } else {
                 if (st.pop() != c) return false;
             }
          }
          
      }
        
      return st.isEmpty();
    }
}