package stack;

public class IntegerArrayStack implements Stack {

    private final int[] array;
    int size;
    int top;

    public IntegerArrayStack(int capacity) {
        this.array = new int[capacity];
        this.top = -1;
        this.size = 0;
    }

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
        if(top==array.length-1){
            System.out.println("Stack is Overflow");
            return;
        }
        top++;
        array[top] = data;
        size++;
    }

    @Override
    public int pop() {
        if (isUnderflow()) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        int popped = array[top];
        array[top--] = 0;
        size--;
        return popped;
    }

    @Override
    public int peek() {
        if (isUnderflow()) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        return array[top];
    }

    @Override
    public void print() {
        if (isUnderflow()) {
            System.out.println("[]");
            return;
        }

        int temp=top;
        System.out.print("[ ");
        for (int i = 0; i <size; i++) {
            System.out.print(array[temp++] + " => ");
        }
        System.out.println(" ]");
    }
}