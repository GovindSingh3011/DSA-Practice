package linkedList.singly;

public interface SinglyLinkedList {
    boolean isEmpty();

    int getSize();

    void addbeginning(int data);

    void addFirst(int data);

    void add(int data);

    int removeFirst();

    int remove(int data);

    SinglyNode search(int data);

    void print();

}
