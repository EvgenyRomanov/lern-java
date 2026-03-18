package algorithms_and_data_structures.doubly_linked_list;

import com.sun.source.tree.WhileLoopTree;

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
            t = t.next;
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

    // Возвращается конец развернутого списка.
    public Node revertRecursive(Node v) {
        if (v == null) {
            return null;
        }

        // Развернуть всё, что идёт после элемента.
        // Возвращается конец развернутого списка, после него должны записать элемент.
        Node t = revertRecursive(v.next);
        if (t != null) {
            t.next = v;
        }

        v.prev = t;
        return v;
    }

    /**
     * O(N) + память на стек.
     */
    public void revertSlow() {
        Node tmp = revertRecursive(start);
        if (tmp != null) {
            tmp.next = null;
        }

        Node t = start;
        start = end;
        end = t;
    }


    public void revert() {
        if (start == null) {
            return;
        }

        Node a = start;
        Node b = start.next;
        a.next = null;
        if (b == null) {
            return;
        }
        Node c = b.next;

        while (b != null) {
            b.next = a;
            a.prev = b;
            a = b;
            b = c;
            if (c != null) {
                c = c.next;
            }
        }

        a.prev = null;
        Node t = start;
        start = end;
        end = t;
    }

    /**
     * Поиск зацикленности.
     */
    public void findCycle() {
        Node a = start;
        Node b = start;

        while (true) {
            if (b == null) break;
            b = b.next;
            if (a == b) break;
            if (b == null) break;
            b = b.next;
            if (a == b) break;
            a = a.next;
        }

        if (b == null) {
            System.out.println("No cycle");
            return;
        }
        b = b.next;
        while (a != b) {
            System.out.print(b.x + " ");
            b = b.next;
        }
        System.out.print(b.x);
        System.out.println();
    }

    static void main(String[] args) {
        var dll = new DoublyLinkedList();
        dll.pushBack(1);
        dll.pushBack(2);
        dll.print();

        dll.revertSlow();
        dll.print();

        // -----
        dll.revert();
        dll.print();

        dll.findCycle();
        dll.end.next = dll.start;
        dll.findCycle();
    }
}
