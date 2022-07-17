

class Solution {
    
public class Pair {
   
    Stack<Integer> st;
    char sign;
    
    Pair(Stack<Integer> st, char sign) {
        this.st = st;
        this.sign = sign;
    }
    
}
    
    public void cal(Stack<Integer> st, int num, char lastsign) {
        
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
        
    }
    public int calculate(String s) {
        
        s = s.trim();
        
        Stack<Integer> st = new Stack<>();
        Stack<Pair> stp = new Stack<>();
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
                
                cal(st, num, lastsign);
                
            } else if (c == '(') {
                stp.add(new Pair(st, lastsign));
                st = new Stack<>();
                lastsign = '+';
            } else if (c == ')') {
                // calculate temp result;
                int temp = 0;
                while (!st.isEmpty()) temp += st.pop();
                
                // get the previous stack and sign
                Pair pair = stp.pop();
                lastsign = pair.sign;
                st = pair.st;
                
                cal(st, temp, lastsign);
                
            }
            else if (c != ' ') {
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