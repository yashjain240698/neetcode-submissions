class Node {
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
class LRUCache {
    Map<Integer, Node> kvStore;
    int capacity = 0;
    Node head;
    Node rear;
    Node front;

    private void addNode(Node node) {
        Node prev = this.front.prev;
        prev.next = node;
        node.prev = prev;
        node.next = front;
        this.front.prev = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        kvStore = new HashMap<>();
        rear = new Node(0, 0);
        front = new Node(0, 0);
        rear.next = front;
        front.prev = rear;
    }

    public int get(int key) {
        if (kvStore.containsKey(key)) {
            removeNode(kvStore.get(key));
            addNode(kvStore.get(key));
            // System.out.println(key + " " + kvStore.size());
            return kvStore.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (kvStore.containsKey(key)) {
            removeNode(kvStore.get(key));
        }

        Node tmp = new Node(key, value);
        kvStore.put(key, tmp);
        addNode(tmp);

        if (kvStore.size() > capacity) {
            //System.out.println("add " + key + " " + kvStore.size() + " remove " + head.key);
            kvStore.remove(rear.next.key);
            removeNode(rear.next);
        }
    }
}
