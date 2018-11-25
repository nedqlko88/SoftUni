import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class P04Orders {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, double[]> products = new LinkedHashMap<>();
        String line;

        while (!"buy".equals(line = reader.readLine())) {
            String[] input = line.split("\\s+");
            String name = input[0];
            double price = Double.parseDouble(input[1]);
            double quantity = Double.parseDouble(input[2]);
            double[] info = new double[] {price, quantity};

            if (products.containsKey(name)) {
                info[1] += products.get(name)[1];
                products.put(name, info);
            }
            products.putIfAbsent(name, info);
        }

        for (Map.Entry<String, double[]> entry : products.entrySet()) {
            System.out.println(String.format("%s -> %.2f", entry.getKey(), entry.getValue()[0] * entry.getValue()[1]));
        }


    }
}
