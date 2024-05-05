package linkedList.singly;

public class SinglyNode {
    int data;
    SinglyNode next;

    public SinglyNode(int data) {
        this.data = data;
    }

    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}