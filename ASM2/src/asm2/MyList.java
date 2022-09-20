package asm2;

/**
 * MyList
 * 
 * @param <T>
 */
public class MyList<T> {
    Node<T> head, tail;

    // tạo constructor khởi tạo list
    MyList() {
        head = tail = null;
    }

    // reset linked list
    public void clear() {
        head = tail = null;
    }

    // kiểm tra list có rỗng hay không
    public boolean isEmty() {
        return (head == null);
    }

    // tính độ dài của linked list
    public int length() {
        Node<T> current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    // chèn thêm 1 node
    public void insertAtHead(T info) {
        Node<T> newNode = new Node<T>(info);
        newNode.setNext(this.head);
        this.head = newNode;
    }

    // xóa node đầu
    public void deleteFromHead() {
        this.head = this.head.getNext();
    }

    // tìm node
    public Node<T> find(T info) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.getInfo() == info) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // thêm phần tử vào đuôi linked list
    public void insertAtTail(T info) {
        Node<T> newNode = new Node<T>(info);
        if (this.head == null) {
            // thêm node mới gán head và tail nếu danh sách rỗng
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        // chèn node mới vào đôi danh sách nếu ko rỗng
        this.tail.setNext(newNode);
        this.tail = newNode;
    }

    // xóa node tại 1 vị trí
    public void deleteAtPosition(int position) {
        if (head == null) {
            return;
        }
        Node<T> temp = head;

        // nếu position = 1 thì xóa head
        if (position == 1) {
            head = temp.getNext();
            return;
        }
        for (int i = 1; temp != null && i < position; i++) {
            temp = temp.getNext();
        }
        if (temp == null || temp.getNext() == null) {
            return;
        }

        // trỏ node next của node (i - 1) tới node (i + 1)
        Node<T> next = temp.getNext().getNext();
        temp.setNext(next);
    }

    // xóa node tại tail
    public void deleteTail() {

        Node<T> current = head;

        for (int i = 0; i < length(); i++) {
            if (current.getNext() == tail) {
                // set current là null và trỏ vào tail
                current.setNext(null);
                tail = current;
                break;
            }
            current = current.getNext();
        }

    }

    // xóa node chứa item
    public void deleteElement(T item) {
        // nếu như item là head
        if (head.getInfo() == item) {
            head = head.getNext();
            return;
        }

        // nếu như item là tail
        if (tail.getInfo() == item) {
            deleteTail();
            return;
        }

        // vị trí khác
        Node<T> current = head;
        for (int i = 0; i < length(); i++) {
            if (current.getNext().getInfo() == item) {

                // xóa node next của node (i - 1) tới node (i + 1)
                current.setNext(current.getNext().getNext());
                break;
            }
            current = current.getNext();
        }

    }

}