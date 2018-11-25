package p02_bookShop;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {
    private String author;
    private String title;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    public String getAuthor() {
        return this.author;
    }

    protected void setAuthor(String author) {
        if (containsDigit(author)) {
            throw new IllegalArgumentException("Author not valid!");
        }

        this.author = author;
    }

    private boolean containsDigit(String author) {
        String[] names = author.split(" ");
        if (names.length == 1) {
            return false;
        } else {
            int[] digits = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            for (int digit : digits) {
                if (Character.isDigit(names[1].charAt(0))) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getTitle() {
        return this.title;
    }

    protected void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    public double getPrice() {
        return this.price;
    }

    protected void setPrice(double price) {
        if (price < 1) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("Type: ").append(this.getClass().getSimpleName())
               .append(System.lineSeparator())
               .append("Title: ").append(this.getTitle())
               .append(System.lineSeparator())
               .append("Author: ").append(this.getAuthor())
               .append(System.lineSeparator())
               .append("Price: ").append(String.format("%.1f", this.getPrice()))
               .append(System.lineSeparator());
       return sb.toString();

    }
}
