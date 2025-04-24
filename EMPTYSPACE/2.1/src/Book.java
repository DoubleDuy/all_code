public class Book extends Author{
    private String name;
    private Author author;
    private double price;
    private int qty = 0;

    Book(String name, Author author, double price) {
        this.name = name;
        this.getAuthor();
        this.price = price;
    }

    Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.getAuthor();
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString() {
        return "Book["+name+", "+toString()+", "+"price= "+price+", "+"qty= "+qty+"]";
    }
}
