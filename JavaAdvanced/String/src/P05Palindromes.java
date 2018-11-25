import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class P05Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("[,.?!\\s]+");
        Set<String> polindromes = new TreeSet<>();
        for (String word : input) {
            if (isPolintrome(word)) {
                polindromes.add(word);
            }
        }
        System.out.println(polindromes);
    }



    private static boolean isPolintrome(String word) {
        StringBuilder poli = new StringBuilder();
        StringBuilder reversedPoli = new StringBuilder();
        reversedPoli.append(word);
        reversedPoli.reverse();
        poli.append(word);
        return poli.toString().equals(reversedPoli.toString());

    }
}
