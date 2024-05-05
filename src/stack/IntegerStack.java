package stack;

public class IntegerStack implements Stack {
    int size = 0;
    StackNode top;

    @Override
    public boolean isUnderflow() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void push(int data) {
        StackNode node = new StackNode(data);
        node.next = top;
        top = node;
        size++;

    }

    @Override
    public int pop() {
        if (isUnderflow()) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        StackNode popNode = top;
        top = top.next;
        size--;
        return popNode.data;
    }

    @Override
    public int peek() {
        if (isUnderflow()) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        return top.data;
    }

    @Override
    public void print() {
        if (isUnderflow()) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        StackNode currentNode = top;
        while (currentNode != null) {
            System.out.print(currentNode.data);
            if (currentNode.next != null) {
                System.out.print("=>");
            }
            currentNode = currentNode.next;
        }
        System.out.println("]");
    }


}