package asm2;

public class Product {
    String bcode;
    String title;
    Integer quantity;
    Double price;

    public Product() {
        bcode = null;
        title = null;
        quantity = null;
        price = null;
    }

    public Product(String bcode, String title, Integer quantity, Double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return " ID = " + bcode +
                ",  " + title +
                ",  quantity: " + quantity +
                ",  price: " + price;
    }

}
