import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        ShoppingCart myBag = new ShoppingCart();
        myBag.add( new CD("Album A", 35, "Artist X"));
        myBag.add( new Book("Book N", 250, "Publisher K"));
        myBag.add( new CD("Album B", 150, "Artist Y"));
        myBag.add( new CD("Album C", 40, "Artist Z"));
        myBag.add( new Book("Book M", 50, "Publisher L"));
        myBag.add( new Item("Cake", 20));
        myBag.show();
        System.out.println( "Total: " + myBag.allSum() + "k VND");
    }
}

interface Product {
    String getName();
    Integer getPrice();
    void printDetail();
}

class Item implements Product{
    private String name;
    private Integer price;

    public Item() {}

    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public void printDetail() {
        System.out.println(String.format("Name: %s, Price: %s", this.name, this.price));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
class Book extends Item{
    private String publisher;

    public Book(){}

    public Book(String name, Integer price, String publisher) {
        super(name, price);
        this.publisher = publisher;
    }

    @Override
    public void printDetail() {
        System.out.println(String.format("Name: %s, Price: %s, Publisher: %s", this.getName(), this.getPrice(), this.publisher));
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
class CD extends Item {
    private String artist;

    public CD() {}

    public CD(String name, Integer price, String artist) {
        super(name, price);
        this.artist = artist;
    }

    @Override
    public void printDetail() {
        System.out.println(String.format("Name: %s, Price: %s, Artist: %s", this.getName(), this.getPrice(), this.artist));
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}

class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void add(Product item) {
        this.products.add(item);
    }

    public void show() {
        for (Product item: this.products) {
            item.printDetail();
        }
    }

    public Integer allSum() {
        int totalAmount = 0;
        for (Product item: this.products
             ) {
            totalAmount = totalAmount + item.getPrice();
        }
        return totalAmount;
    }
}
