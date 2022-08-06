class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        // sort the array in  decreasing order of height
        // if height are equal then sort in asc order
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        // Go through each element and just insert it at k position
        // largest one will go first
        List<int[]> result = new ArrayList<>();
        
        for (int[] p : people) result.add(p[1], p);
        
        return result.toArray(new int[people.length][2]);
        
    }
}