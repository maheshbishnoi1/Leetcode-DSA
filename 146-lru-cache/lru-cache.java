class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head;
    Node tail;
    HashMap<Integer,Node> map;
    int cap ;

    public LRUCache(int capacity) {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;

        cap = capacity;

        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            node.value = value;
            insert(node);
        } else {
            Node node = new Node(key,value);
            map.put(key,node);
            insert(node);
            if(map.size() > cap){
                Node lru = head.next;

                remove(lru);
                map.remove(lru.key);
            }
        }
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
    private void insert(Node node){
        Node prevs = tail.prev;


        prevs.next = node;
        node.prev = prevs;

        node.next = tail;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */