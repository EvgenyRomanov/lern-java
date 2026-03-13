package algorithms_and_data_structures.linked_list;

/**
 * Односвязные списки.
 *
 * Позволяет вставлять в начало или конец за O(1).
 * В середину за O(1), если известно после какого элемента будет вставка.
 */
public class LinkedList {
    class Node {
        int x;
        Node next;

        public Node(int x) {
            this.x = x;
            this.next = null;
        }
    }
}
