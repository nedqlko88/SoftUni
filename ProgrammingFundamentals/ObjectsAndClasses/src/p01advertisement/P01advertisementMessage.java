package p01advertisement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Random;

public class P01advertisementMessage {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        String[] phrases = new String[] {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = new String[] {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = new String[] {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = new String[] {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        Random rnd = new Random();

        for (int i = 0; i < count; i++) {
            int phraseRandomIndex = rnd.nextInt(phrases.length - 1);
            int eventsRandomIndex = rnd.nextInt(events.length - 1);
            int authorsRandomIndex = rnd.nextInt(authors.length - 1);
            int citiesRandomIndex = rnd.nextInt(cities.length - 1);

            System.out.println(phrases[phraseRandomIndex] + " " + events[eventsRandomIndex] + " "
            + authors[authorsRandomIndex] + " - " + cities[citiesRandomIndex]);
        }
    }
}
