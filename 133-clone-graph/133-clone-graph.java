/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if (node == null) return node;
        
        // using BFS
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        
        while (!q.isEmpty()) {
           
            Node curr = q.poll();
            
            for (Node n : curr.neighbors) {
                
                if (!map.containsKey(n)) {
                    Node nClone = new Node(n.val);
                    map.put(n, nClone);
                    q.add(n);
                }
                
                // add the neighbours to clone
                map.get(curr).neighbors.add(map.get(n));
            }          
        }
        
        return cloneNode;
    }
}