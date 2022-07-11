class Solution {
    public String customSortString(String order, String s) {
        
        int[] frequency = new int[26];
        
        // fill it
        for (char c : s.toCharArray()) frequency[c - 'a']++;
        
        System.out.println(s);
        System.out.println(Arrays.toString(frequency));
        
        StringBuilder result = new StringBuilder();
        
        for (char c : order.toCharArray()) {
            
            if (frequency[c - 'a'] == 0) continue;
            
            while(frequency[c - 'a'] > 0) {
                result.append(c);
                frequency[c - 'a']--;
            }
            
        }
        
        // collect other chars
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == 0) continue;
            
            int count = frequency[i];
            while (count > 0) {
                result.append((char)(i + 97));
                count--;
            }
         }
        
        return result.toString();
    }
}