class LRUCache {
    
    int capacity;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    
    Map<Integer, Node> map = new HashMap<>();
    
    public LRUCache(int capacity) {
      this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    // Remove the node from map and DLL
    private void remove(Node node) {
        
        map.remove(node.key);
        
        node.prev.next = node.next;
        node.next.prev = node.prev;        
        
    }
    
    //insert the node in Map and DLL
    private void insert(Node node){
        
        map.put(node.key, node);
        
        Node next = head.next;
        
        head.next = node;
        node.next = next;
        
        next.prev = node;
        node.prev = head;
        
        
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)) {
            
            Node node = map.get(key);
            
            // remove the node from map and LL
            remove(node);
            
            // Insert it after the Head Node as Used
            insert(node);
            
            return node.value;
            
        } else {
            return -1;
        }
        
        
        
    }
    
    public void put(int key, int value) {
        
        // Check if its already in the map
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        
        // check if capacity has reached -> remove LRU 
        if(map.size() == capacity) {
            remove(tail.prev);
        }
        
        // Insert in the system after HeadNode
        insert(new Node(key, value));       
        
        
    }
    
    // Node class
    class Node {
        
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */