class Solution {
    
        private String helper(Queue<Character> q) {

        StringBuilder sb = new StringBuilder();
        int num = 0;

        while (!q.isEmpty()) {

            char c = q.poll();

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {

                String sub = helper(q);
                while (num > 0) {
                    sb.append(sub);
                    num--;
                }


            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }


        }

        return sb.toString();
    }
    
    public String decodeString(String s) {
        
        
        Queue<Character> q = new LinkedList<>();

        for (char c : s.toCharArray()) q.add(c);
        
        return helper(q);
        
    }
}