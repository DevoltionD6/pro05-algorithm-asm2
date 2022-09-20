package asm2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class OperationToProduct {

    Scanner sc = new Scanner(System.in);

    /**
     * Searching and returning the index of product p in the list. If not found
     * return -1.
     * 
     * @param p    Product for searching
     * @param list The Linked List
     * @return The index of product p in the list
     */

    public int index(Product p, MyList<Product> list) {
        int index = 0;
        Node<Product> current = list.head;
        while (current != null) {
            if (current.getInfo() == p) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;

    }

    /**
     * Creating and returning a product with info input from keyboard - tạo sản phẩm
     * mới.
     * 
     * @return The product
     * 
     */

    public static Product createProduct(Scanner sc) {
        System.out.println("New ID: ");
        String bcode = sc.next();
        System.out.println("Product's Name: ");
        sc.nextLine();
        String title = sc.nextLine();
        System.out.println("Product's quantity: ");
        int quantity = sc.nextInt();
        System.out.println("Product's Price: ");
        double price = sc.nextDouble();
        Product newProduct = new Product(bcode, title, quantity, price);

        return newProduct;

    }

    /**
     * 
     * Reading all products from the file and insert them to the list at tail.
     * 
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     * 
     */

    // đọc dữ liệu file text và lưu vào list
    public static void getAllItemsFromFileSaveToList(String fileName, MyList<Product> list) {
        try {
            // tạo luồng dữ liệu đầu vào để đọc file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            // đọc file và lưu vào linked list
            String line = "";
            while ((line = reader.readLine()) != null) {

                // tách chuỗi thành xâu để đưa dữ liệu vào
                String[] row = line.split(",");
                Product product = new Product(row[0], row[1], Integer.parseInt(row[2]), Double.parseDouble(row[3]));
                list.insertAtTail(product);
            }
            reader.close();
            System.out.println("Successfully!");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Fail!!!");
        }
    }

    // lưu dữ liệu từ linked list vào file text
    public static void writeAllItemsToFile(String fileName, MyList<Product> list) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            Node<Product> current = list.head;
            while (current != null) {
                // ghi dữ liệu có trong node
                writer.write(current.getInfo().bcode + "," + current.getInfo().title + "," + current.getInfo().quantity
                        + "," + current.getInfo().price);

                // ghi dữ liệu vào bộ nhớ đệm tệp
                writer.flush();

                // ghi dòng mới
                writer.newLine();
                current = current.getNext();
            }
            writer.close();
            System.out.println("Your product has been saved to " + fileName + "!");

        } catch (Exception e) {
            System.out.println("Fail!!!");
            // TODO: handle exception
        }

    }

    // đọc dữ liệu file text và lưu vào stack
    public static void getAllItemsFromFileSaveToStack(String fileName, MyStack<Product> stack) {
        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";

            while ((line = reader.readLine()) != null) {

                // cắt chuỗi
                String[] row = line.split(",");

                // tạo sản phẩm mới
                Product product = new Product(row[0], row[1], Integer.parseInt(row[2]), Double.parseDouble(row[3]));

                // đưa sản phẩm vào stack
                stack.push(product);
            }
            reader.close();
            System.out.println("Succesfully!");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Fail!!!");
        }
    }

    // đọc dữ liệu từ file text và lưu vào queue
    public static void getAllItemsFromFileSaveToQueue(String fileName, MyQueue<Product> queue) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";

            while ((line = reader.readLine()) != null) {

                // cắt chuỗi
                String[] row = line.split(",");

                // tạo sản phẩm mới
                Product product = new Product(row[0], row[1], Integer.parseInt(row[2]), Double.parseDouble(row[3]));

                // đưa sản phẩm vào stack
                queue.enqueue(product);
            }
            reader.close();
            System.out.println("Succesfully!");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Fail!!!");
        }
    }

    // thêm sản phẩm vài cuối linked list
    public static void addLast(MyList<Product> list, Scanner sc) {
        Product newProduct = createProduct(sc);
        list.insertAtTail(newProduct);
    }

    // hiển thị linked list
    public static void displayAllList(MyList<Product> list) {

        // kiểm tra rỗng
        if (list.isEmty()) {
            return;
        }
        System.out.println("_______________");
        System.out.println();

        // duyệt qua từng phần tử của list
        Node<Product> current = list.head;
        while (current != null) {

            System.out.println(current.getInfo().toString());
            current = current.getNext();
        }
    }

    // hiển thị stack của sản phẩm
    public static void displayAllStack(MyStack<Product> stack) {

        // kiểm tra stack rỗng?
        if (stack.isEmty()) {
            return;
        }
        System.out.println();
        System.out.println();

        // duyệt và hiển thị
        while (!stack.isEmty()) {
            System.out.println(stack.pop().toString());

        }
    }

    // hiển thị queue của sản phẩm
    public static void displayAllQueue(MyQueue<Product> queue) throws Exception {
        if (queue.isEmty()) {
            return;
        }
        System.out.println("_______________");
        System.out.println();
        while (!queue.isEmty()) {
            System.out.println(queue.dequeue().toString());

        }
    }

    // tìm kiếm theo id
    public static void searchByCode(MyList<Product> list, Scanner sc) {
        System.out.println();
        System.out.print("Your search ID is ");
        String searchID = sc.next();
        Node<Product> current = list.head;
        while (current != null) {
            if (current.getInfo().bcode.equalsIgnoreCase(searchID)) {
                System.out.println(current.getInfo().toString());

                return;
            }
            current = current.getNext();
        }
        System.out.println("No product found by this ID !!!");

    }

    // tìm kiếm/ xóa sản phẩm trong linkedlist
    public static void deleteByCode(MyList<Product> list, Scanner sc) {
        System.out.println();
        System.out.println("What ID you wanna Delete?");
        String idDelete = sc.next();
        Node<Product> current = list.head;
        while (current != null) {
            if (current.getInfo().bcode.equalsIgnoreCase(idDelete)) {
                list.deleteElement(current.getInfo());
                System.out.println("Product " + idDelete + " has been delete!!!");
                return;
            }
            current = current.getNext();
        }
    }

    // sắp xếp sp theo id
    public static void sortByCode(MyList<Product> list) {
        if (list.isEmty()) {
            return;
        }

        // sắp xếp
        seletionSortByCode(list, list.head);
        System.out.println("Your product list has been sort !!!");
    }

    // selection sort
    public static void seletionSortByCode(MyList<Product> list, Node<Product> i) {
        if (i == list.tail) {
            return;
        }
        Node<Product> minPosition = i;
        for (Node<Product> j = i.getNext(); j != null; j = j.getNext()) {
            if (j.getInfo().bcode.compareToIgnoreCase(minPosition.getInfo().bcode) < 0) {
                minPosition = j;
            }
        }
        Product temp = minPosition.getInfo();
        minPosition.setInfo(i.getInfo());
        i.setInfo(temp);

        // sử dụng đệ quy
        seletionSortByCode(list, i.getNext());

    }

    /**
     * Thêm sản phẩm vào đầu linked list
     * 
     * @param list  linked list của sản phẩm
     * @param input nhập thông tin từ bàn phím
     */
    public void addFirst(MyList<Product> list, Scanner sc) {
        Product newProduct = createProduct(sc);
        list.insertAtHead(newProduct);
    }

    // đẩy 1 phẩn tử vào stack

    // chuyển decimal sang binary
    public static int convertToBinary(int x) {
        int d = x % 2;
        if (x == 0) {
            return 0;
        }

        // sử dụng đệ quy để chia đến hết x
        return d + 10 * convertToBinary(x / 2);
    }

    // xóa sản phẩm tại vị trí nhất định
    public void deleteAtPosition(MyList<Product> list, int x) {
        list.deleteAtPosition(x);
    }

}
