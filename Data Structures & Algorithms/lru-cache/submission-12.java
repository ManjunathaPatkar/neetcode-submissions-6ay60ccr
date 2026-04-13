class LRUCache {
    int capacity;
    Map<Integer,Node> hm;
    Node head;
    Node last;
    class Node {
        int val;
        int key;
        Node next;
        Node prev;
        Node(int key, int val){
            this.key= key;
            this.val = val;
            this.next= null;
            this.prev= null;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hm = new HashMap<>();
        this.head = null;
        this.last = null;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        Node node = hm.get(key);
        if(node == head){
            return node.val;
        }
        if(node == last){
            last = last.prev;
            last.next=null;
        }
        if(node.prev!=null){
            node.prev.next = node.next;
        }
        if(node.next!=null){
            node.next.prev = node.prev;
        }
        node.next= head;
        head.prev =node;
        head= node;
        return node.val;
    }
    
    public void put(int key, int value) {
        if(!hm.containsKey(key)){
            if(capacity==0){
                hm.remove(last.key);
                if(last==head){
                    head=null;
                    last=null;
                }else{
                    last = last.prev;
                    last.next=null;
                }
                capacity++;
            }
            Node node = new Node(key,value);
            if(head==null){
                head=node;
                last=node;
                hm.put(key,node);
            }else{
                node.next= head;
                head.prev =node;
                head= node;
                hm.put(key,node);
            }
            capacity--;
        }
        else{
            Node node = hm.get(key);
            node.val = value;
            if(node==head){
                return;
            }
            if(node==last){
                last = last.prev;
                last.next=null;
            }
            if(node.prev!=null){
                node.prev.next = node.next;
            }
            if(node.next!=null){
                node.next.prev = node.prev;
            }
            node.next= head;
            head.prev =node;
            head= node;
        }
    }
}
