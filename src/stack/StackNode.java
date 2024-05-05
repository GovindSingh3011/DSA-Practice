package stack;

public class StackNode {
    int data;
    StackNode next;

    public StackNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
