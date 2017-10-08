class LRUCache {

    public int capacity;
    DNode head = null;
    DNode tail = null;
     Map<Integer,DNode> map = new HashMap<Integer, DNode>();
    public LRUCache(int capacity) {
        this.capacity = capacity; 
    }
    
    public void deleteNode(DNode node){
        if(node.pre!=null){
            node.pre.next = node.next;
        }else{
           head = node.next; 
        }
        
        if(node.next!=null){
            node.next.pre = node.pre;
        }
        else{
            tail = node.pre;
        }
    }
    
    public void setHead(DNode node){
        node.next=head;
        node.pre = null;
        if(head != null){
            head.pre = node;
        }
        head = node;
        if(tail == null){
            tail = head;
        } 
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DNode n = map.get(key);
            DNode newOne = new DNode(key,n.val);
            deleteNode(n);
            setHead(newOne);
            return n.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DNode n = map.get(key);
            n.val = value;
            deleteNode(n);
            setHead(n);
        }
        else{
            DNode created = new DNode(key,value);
            if(map.size() == capacity){
               map.remove(tail.key);
               deleteNode(tail);
               setHead(created);
            }
            else{
                setHead(created);
            }
            map.put(key,created);
        }
        
    }

}

class DNode{
    int key;
    int val;
    DNode pre;
    DNode next;
    
    public DNode(int k, int v){
        this.key = k;
        this.val = v;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
