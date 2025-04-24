public class Thesis {
    private String thesisID;
    private String title;
    private int year;
    private String author;

    public Thesis(String thesisID, String title, int year, String author) {
        this.thesisID = thesisID;
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public String getThesisID() { return thesisID; }
    public void setThesisID(String thesisID) { this.thesisID = thesisID; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}