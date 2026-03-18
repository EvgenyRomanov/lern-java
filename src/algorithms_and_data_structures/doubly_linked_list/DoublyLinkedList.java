package algorithms_and_data_structures.doubly_linked_list;

public class DoublyLinkedList {
    class Node {
        int x;
        Node next;
        Node prev;

        public Node(int x) {
            this.x = x;
            this.next = null;
            this.prev = null;
        }
    }

    Node start;
    Node end;

    public DoublyLinkedList() {
        start = null;
        end = null;
    }

    public void print() {
        Node t = start;
        while (t != null) {
            System.out.print(t.x + " ");
        }
        System.out.println();
    }

    /**
     * Вставка в начало.
     */
    public void pushFront(int x) {
        Node t = new Node(x);
        if (start == null) {
            start = t;
            end = t;
            return;
        }

        t.next = start;
        start.prev = t;
        start = t;
    }

    /**
     * Новый элемент после какого-то.
     */
    public void insert(Node v, int x) {
        Node t = new Node(x);
        Node next = v.next;

        if (next == null) {
            t.next = null;
            v.next = t;
            t.prev = v;
            end = t;
            return;
        }

        next.prev = t;
        t.next = next;
        v.next = t;
        t.prev = v;
    }

    /**
     * Новый элемент в конец списка.
     */
    public void pushBack(int x) {
        if (end == null) {
            Node t = new Node(x);
            start = t;
            end = t;
            return;
        }

        insert(end, x);
    }

    public void delete(Node v) {
        Node prev = v.prev;
        Node next = v.next;

        if (prev != null) {
            prev.next = next;
        }

        if (next != null) {
            next.prev = prev;
        }

        v.next = null;
        v.prev = null;

        if (v == start) {
            start = next;
        }

        if (v == end) {
            start = prev;
        }
    }

    public void popFront() {
        delete(start);
    }

    public void popBack() {
        delete(end);
    }

    /**
     * O(1).
     */
    public void merge(DoublyLinkedList l) {
        if (l.end == null) {
            return;
        }

        if (end == null) {
            start = l.start;
            end = l.end;
            return;
        }

        end.next = l.start;
        l.start.prev = end;
        end = l.end;
    }
}
