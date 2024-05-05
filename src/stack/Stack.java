package stack;

public interface Stack {

    boolean isUnderflow();

    int getSize();

    void push(int data);

    int pop();

    int peek();

    void print();

}