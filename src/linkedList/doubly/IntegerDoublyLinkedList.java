package linkedList.doubly;

public class IntegerDoublyLinkedList implements DoublyLinkedList {
    int size = 0;
    public DoublyNode head;
    public DoublyNode tail;

    //for check list is empty or not
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //for find size of list
    @Override
    public int getSize() {
        return size;
    }

    //for add first node
    @Override
    public void addFirst(int data) {
        DoublyNode node = new DoublyNode(data, head, tail);
        head = node;
        tail = node;
        size++;
    }

    // for add node at any location
    @Override
    public void add(int data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            DoublyNode node = new DoublyNode(data, head, tail);
            head.next = node;
            tail = node;
            size++;
        }
    }

    //for remove first node
    @Override
    public int removeFirst() {
        int removed = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        size--;
        return removed;
    }

    //for remove from any location
    @Override
    public int remove(int data) {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        DoublyNode currentNode = head;

        while (currentNode != null && currentNode.data != data) {
            currentNode = currentNode.next;
        }
        if (currentNode == null) {
            return Integer.MIN_VALUE;
        }
        if (currentNode == head) {
            return removeFirst();
        }

        currentNode.previous.next = currentNode.next;

        if (currentNode == tail) {
            tail = currentNode.previous;
        } else {
            currentNode.next.previous = currentNode.previous;
        }

        size--;
        return currentNode.data;
    }

    //for search data from list
    @Override
    public DoublyNode search(int data) {
        DoublyNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == data) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    //for print list
    @Override
    public void print() {
        DoublyNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }
    }
}
