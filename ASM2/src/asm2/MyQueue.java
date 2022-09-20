package asm2;

public class MyQueue<T> {

    Node<T> head, tail;

    public MyQueue() {
        head = tail = null;
    }

    // kiểm tra hàng đợi rỗng
    public boolean isEmty() {
        return head == null;
    }

    // xem thông tin của node head
    T front() throws Exception {
        if (isEmty()) {
            throw new Exception();
        }
        return (head.getInfo());

    }

    // xóa node đầu trong queue

    T dequeue() throws Exception {
        if (isEmty()) {
            throw new Exception();
        }
        T item = head.getInfo();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }

        return item;
    }

    // thêm node cuối trong queue
    void enqueue(T item) {
        if (isEmty()) {
            head = tail = new Node<T>(item, null);
        } else {
            Node newNode = new Node<T>(item, null);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

}
