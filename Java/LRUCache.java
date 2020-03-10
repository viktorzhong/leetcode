public class LRUCache {

    private class Node {
      int key, val;
      Node prev, next;

      Node(int key, int val, Node prev, Node next) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
      }
    }

    private Node head = new Node(-1, -1, null, null);
    private Map<Integer, Node> map = new HashMap<>();

    private void move2Head(Node cur) {
      if (cur == head) {
        head = head.prev;
        return;
      }
      // detach
      cur.prev.next = cur.next;
      cur.next.prev = cur.prev;
      // attach
      cur.next = head.next;
      cur.next.prev = cur;
      head.next = cur;
      cur.prev = head;
    }

    public LRUCache(int capacity) {
      Node cur = head;
      for (int i = 0; i < capacity-1; ++i) {
        cur.next = new Node(-1, -1, cur, null);
        cur = cur.next;
      }
      cur.next = head;
      head.prev = cur;
    }

    public int get(int key) {
      if (!map.containsKey(key)) return -1;
      Node cur = map.get(key);
      move2Head(cur);
      return cur.val;
    }

    public void put(int key, int value) {
      if (map.containsKey(key)) {
        Node cur = map.get(key);
        cur.val = value;
        move2Head(cur);
      } else {
        if (head.val != -1) map.remove(head.key);
        head.key = key;
        head.val = value;
        map.put(key, head);
        head = head.prev;
      }
    }
  }