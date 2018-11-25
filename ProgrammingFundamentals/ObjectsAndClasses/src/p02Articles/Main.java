package p02Articles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(", ");
        Article article = new Article(tokens[0], tokens[1], tokens[2]);

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {


            String[] commands = reader.readLine().split(": ");
            String cmd = commands[0];
            String source = commands[1];

            switch (cmd) {
                case "Edit":
                    article.edit(source);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(source);
                    break;
                case "Rename":
                    article.rename(source);
                    break;
            }
        }

        System.out.println(article.toString());
    }
}
