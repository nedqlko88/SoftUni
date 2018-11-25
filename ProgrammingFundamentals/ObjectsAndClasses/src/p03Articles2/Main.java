package p03Articles2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Article article = null;
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(",\\s+");
            article = new Article(tokens[0], tokens[1], tokens[2]);
            articles.add(article);
        }

        String criteria = reader.readLine();

        switch (criteria) {
            case "title":
                articles.stream().sorted(Comparator.comparing(Article::getTitle)).forEach(System.out::println);
                break;
            case "content":
                articles.stream().sorted(Comparator.comparing(Article::getContent)).forEach(System.out::println);
                break;
            case "author":
                articles.stream().sorted(Comparator.comparing(Article::getAuthor)).forEach(System.out::println);
                break;
        }
    }
}
