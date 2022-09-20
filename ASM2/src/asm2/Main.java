package asm2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice;

        // tạo linked list, stack, queue của sản phẩm
        MyList<Product> lProduct = new MyList<Product>();
        MyStack<Product> sProduct = new MyStack<Product>();
        MyQueue<Product> qProduct = new MyQueue<Product>();

        do {
            showMenu();
            choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    OperationToProduct.getAllItemsFromFileSaveToList("data.txt", lProduct);
                    OperationToProduct.displayAllList(lProduct);
                    break;
                case 2:
                    OperationToProduct.addLast(lProduct, sc);
                    System.out.println("Your new product has been saved!");
                    System.out.println();
                    break;
                case 3:
                    OperationToProduct.displayAllList(lProduct);
                    System.out.println();
                    break;
                case 4:
                    OperationToProduct.writeAllItemsToFile("data.txt", lProduct);
                    break;
                case 5:
                    OperationToProduct.searchByCode(lProduct, sc);
                    break;
                case 6:
                    OperationToProduct.deleteByCode(lProduct, sc);
                    break;
                case 7:
                    OperationToProduct.sortByCode(lProduct);
                    break;
                case 8:
                    Product firstP = lProduct.head.getInfo();
                    System.out.println("The first Quantity of Product is " + firstP.quantity);
                    System.out.println("Conver to binary: " + OperationToProduct.convertToBinary(firstP.quantity));
                    break;
                case 9:
                    OperationToProduct.getAllItemsFromFileSaveToStack("data.txt", sProduct);
                    OperationToProduct.displayAllStack(sProduct);
                    break;
                case 10:
                    OperationToProduct.getAllItemsFromFileSaveToQueue("data.txt", qProduct);
                    OperationToProduct.displayAllQueue(qProduct);
                    break;
                case 0:
                    System.out.println("");
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Opps somethings swrong!!! Try again");
                    break;
            }
        } while (choice != 0);

    }

    public static void showMenu() {

        System.out.println("Choose one of this options:");

        System.out.println("Product list:");

        System.out.println("1. Load data from file and display");

        System.out.println("2. Input & add to the end.");

        System.out.println("3. Display data");

        System.out.println("4. Save product list to file.");

        System.out.println("5. Search by ID");

        System.out.println("6. Delete by ID");

        System.out.println("7. Sort by ID.");

        System.out.println("8. Convert to Binary");

        System.out.println("9. Load to stack and display");

        System.out.println("10. Load to queue and display.");

        System.out.println("0. Exit");

    }
}
