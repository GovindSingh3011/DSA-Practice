package linkedList.doubly;

public interface DoublyLinkedList {
    boolean isEmpty();

    int getSize();

    void addFirst(int data);

    void add(int data);

    int removeFirst();

    int remove(int data);

    DoublyNode search(int data);

    void print();

}
