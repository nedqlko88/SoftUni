import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        Character[] vowels = new Character[] {'a', 'u', 'o', 'y', 'e', 'i'};

        int countOfVowels = countVowels(input, vowels);

        System.out.println(countOfVowels);
    }

    private static int countVowels(String input, Character[] vowels) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            for (Character vowel : vowels) {
                if (input.charAt(i) == vowel) {
                    count++;
                }
            }
        }
        return count;
    }
}
