package lectures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;


    public Book(String title, int year, String... values) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(values);

    }

    public String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(String... values) {
        this.authors = new ArrayList<>();
        Collections.addAll(authors, values);
    }

    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Title: ").append(this.getTitle())
            .append(" year: ").append(this.getYear())
            .append(" Authors: ").append(String.join(", ", this.getAuthors()));
    return sb.toString();
    }

    @Override
    public int compareTo(Book o) {
        if (this.getTitle().compareTo(o.getTitle()) == 0) {
//           return this.getYear() - o.getYear();
            return Integer.compare(this.getYear(), o.getYear());

        }

        return this.getTitle().compareTo(o.getTitle());
    }
}
