//App
public class App {
    public static void main(String[] args) {
        Author author1 = new Author("ไก๊ไก่", "guide@example.com", 'M');
        Author author2 = new Author("เอิ่นเอิ๊น", "earn@example.com", 'F');
        Author[] authors = {author1, author2};

        Book book1 = new Book("Book1", authors, 29.95);
        Book book2 = new Book("Book2", authors, 39.95, 100);

        System.out.println(book1);
        System.out.println(book2);

        System.out.println("Author names: " + book1.getAuthorNames());
    }
}
