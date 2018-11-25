import java.util.Scanner;

public class metricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numForExchange = Double.parseDouble(scanner.nextLine());
        String inMetric = scanner.nextLine();
        String outMetric = scanner.nextLine();
        double mToMM = 1000;
        double mToCM = 100;
        double mToMI = 0.000621371192;
        double mToIN = 39.3700787;
        double mToKM = 0.001;
        double mToFT = 3.2808399;
        double mToYD = 1.0936133;
        double firstOne = 0;
        if ("m".equalsIgnoreCase(inMetric)) {
            firstOne = numForExchange;
        } else if ("mm".equalsIgnoreCase(inMetric)) {
            firstOne = numForExchange / mToMM;
        } else if ("cm".equalsIgnoreCase(inMetric)) {
            firstOne = numForExchange / mToCM;
        } else if ("mi".equalsIgnoreCase(inMetric)) {
            firstOne = numForExchange / mToMI;
        } else if ("in".equalsIgnoreCase(inMetric)) {
            firstOne = numForExchange / mToIN;
        } else if ("km".equalsIgnoreCase(inMetric)) {
            firstOne = numForExchange / mToKM;
        } else if ("ft".equalsIgnoreCase(inMetric)) {
            firstOne = numForExchange / mToFT;
        } else if ("yd".equalsIgnoreCase(inMetric)) {
            firstOne = numForExchange / mToYD;
        } else {
            System.out.println("You entered unvalid input metric");
        }

        double finalConvert = 0;
        if ("m".equalsIgnoreCase(outMetric)) {
            finalConvert = firstOne;
        } else if ("mm".equalsIgnoreCase(outMetric)) {
            finalConvert = firstOne * mToMM;
        } else if ("cm".equalsIgnoreCase(outMetric)) {
            finalConvert = firstOne * mToCM;
        } else if ("mi".equalsIgnoreCase(outMetric)) {
            finalConvert = firstOne * mToMI;
        } else if ("in".equalsIgnoreCase(outMetric)) {
            finalConvert = firstOne * mToIN;
        } else if ("km".equalsIgnoreCase(outMetric)) {
            finalConvert = firstOne * mToKM;
        } else if ("ft".equalsIgnoreCase(outMetric)) {
            finalConvert = firstOne * mToFT;
        } else if ("yd".equalsIgnoreCase(outMetric)) {
            finalConvert = firstOne * mToYD;
        } else {
            System.out.println("You entered unvalid output metric");

        }
        System.out.printf("%.8f %s", finalConvert, outMetric.toLowerCase());
    }


}
