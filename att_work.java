import java.util.Arrays;

public class att_work {

    private static final int INITIAL_CAPACITY = 16;
    private Node[] table;
    private int size;

    public static void main() {

        att_work hashMap = new att_work();

        hashMap.put(1, 10);
        hashMap.put(2, 20);
        hashMap.put(3, 30);

        System.out.println("Size: " + hashMap.size());
        System.out.println("Contains Key 2: " + hashMap.containsKey(2));
        System.out.println("Contains Value 30: " + hashMap.containsValue(30));
        System.out.println("Get Value for Key 3: " + hashMap.get(3));

        hashMap.remove(2);

        System.out.println("Size after removal: " + hashMap.size());
        
    }


    public att_work() {
        table = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    public Object put(Integer key, Integer value) {
        int index = getIndex(key);
        Node newNode = new Node(key, value);

        if (table[index] == null) {
            table[index] = newNode;
            size++;
        } else {
            Node currentNode = table[index];
            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    Object oldValue = currentNode.value;
                    currentNode.value = value;
                    return oldValue;
                }

                if (currentNode.next == null) {
                    currentNode.next = newNode;
                    size++;
                    break;
                }

                currentNode = currentNode.next;
            }
        }

        return null;
    }

    public Object get(Integer key) {
        int index = getIndex(key);
        Node currentNode = table[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    public Object remove(Integer key) {
        int index = getIndex(key);
        Node currentNode = table[index];
        Node prevNode = null;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (prevNode == null) {
                    table[index] = currentNode.next;
                } else {
                    prevNode.next = currentNode.next;
                }
                size--;
                return currentNode.value;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

    public Object replace(Integer key, Integer value) {
        int index = getIndex(key);
        Node currentNode = table[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                Object oldValue = currentNode.value;
                currentNode.value = value;
                return oldValue;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(Integer key) {
        int index = getIndex(key);
        Node currentNode = table[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public boolean containsValue(Integer value) {
        for (Node node : table) {
            Node currentNode = node;
            while (currentNode != null) {
                if (currentNode.value.equals(value)) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }

        return false;
    }

    private int getIndex(Integer key) {
        return key.hashCode() % table.length;
    }

    private static class Node {
        private Integer key;
        private Integer value;
        private Node next;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        att_work hashMap = new att_work();

        hashMap.put(1, 10);
        hashMap.put(2, 20);
        hashMap.put(3, 30);

        System.out.println("Size: " + hashMap.size());
        System.out.println("Contains Key 2: " + hashMap.containsKey(2));
        System.out.println("Contains Value 30: " + hashMap.containsValue(30));
        System.out.println("Get Value for Key 3: " + hashMap.get(3));

        hashMap.remove(2);

        System.out.println("Size after removal: " + hashMap.size());
    }
}
