import java.util.*;

public class P10SnowBalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Long> sumsOfAll = new ArrayList<>(n);
        long maxResult = 0L;
        int bestSnow = 0;
        int bestTime = 0;
        int bestQuality = 0;


        for (int i = 0; i < n; i++) {


            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            sumsOfAll.add((long)Math.pow((snowballSnow / snowballTime), snowballQuality));

            if (sumsOfAll.get(i) >= Collections.max(sumsOfAll)) {
                bestSnow = snowballSnow;
                bestTime = snowballTime;
                bestQuality = snowballQuality;
                maxResult = sumsOfAll.get(i);
            }
        }

        System.out.printf("%d : %d = %d (%d)", bestSnow, bestTime, maxResult, bestQuality);
    }
}
