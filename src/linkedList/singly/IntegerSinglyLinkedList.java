package linkedList.singly;

public class IntegerSinglyLinkedList implements SinglyLinkedList {
    int size;
    SinglyNode head;

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

    //for add node at beginning
    @Override
    public void addbeginning(int data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            SinglyNode newNode = new SinglyNode(data);
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    //for add first node
    @Override
    public void addFirst(int data) {
        head = new SinglyNode(data);
        size++;
    }

    //for add node at any location
    @Override
    public void add(int data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            SinglyNode newNode = head;
            while (newNode.next != null) {
                newNode = newNode.next;
            }
            newNode.next = new SinglyNode(data);
            size++;
        }
    }

    //for remove first node
    @Override
    public int removeFirst() {
        if (head != null) {
            head = head.next;
            size--;
        }
        return 0;
    }

    //for remove from any location
    @Override
    public int remove(int data) {

        if (isEmpty()) {
            System.out.println("List is Empty");
            return Integer.MIN_VALUE;
        }
        if (head.data == data) {

            return removeFirst();
        } else {
            SinglyNode tempNode = head;
            SinglyNode preNode = null;

            while (tempNode != null && tempNode.data != data) {
                preNode = tempNode;
                tempNode = tempNode.next;
            }
            if (tempNode == null) {
                System.out.println("Data not Found");
                return Integer.MIN_VALUE;
            }
            preNode.next = tempNode.next;
            size--;

            return tempNode.data;
        }


    }

    //for search data from list
    @Override
    public SinglyNode search(int data) {
        SinglyNode currentNode = head;
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
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        SinglyNode currentnode = head;
        while (currentnode != null) {
            System.out.print(currentnode.data);
            if (currentnode.next != null) {
                System.out.print("=>");
            }
            currentnode = currentnode.next;
        }
        System.out.println("]");
    }
}
