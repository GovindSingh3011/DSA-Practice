package linkedList.doubly;

public class DoublyNode {
    int data;
    public DoublyNode next;
    public DoublyNode previous;

    public DoublyNode(int data) {
        this.data = data;
    }

    public DoublyNode(int data, DoublyNode next, DoublyNode previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", next=" + next + ", previous=" + previous + '}';
    }
}
