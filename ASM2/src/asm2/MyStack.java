package asm2;

import java.util.EmptyStackException;

public class MyStack<T> {
    Node<T> head;

    public MyStack() {
        head = null;
    }

    boolean isEmty() {
        return head == null;
    }

    // thêm node vào đâu stack
    void push(T item) {
        head = new Node<T>(item, head);
    }

    // xem thông tin node head
    T top() throws EmptyStackException {

        if (isEmty()) {
            throw new EmptyStackException();

        }
        return head.getInfo();

    }

    // xóa node head khỏi stack

    T pop() throws EmptyStackException {
        if (isEmty()) {
            throw new EmptyStackException();
        }
        T item = head.getInfo();
        head = head.getNext();
        return item;
    }

}
