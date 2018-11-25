package p06_custom_annotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String OUTPUT = "Type = %s, Description = %s";
    private static final String RANK_TYPE = "Rank";
    private static final String SUIT_TYPE = "Suit";
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String type = reader.readLine();

        if (RANK_TYPE.equals(type)) {
            Class<RankType> rankTypeClass = RankType.class;

            printAnnotationType(rankTypeClass);

        } else if (SUIT_TYPE.equals(type)){
            Class<SuitType> suitTypeClass = SuitType.class;
            printAnnotationType(suitTypeClass);
        }
    }

    private static void printAnnotationType(Class<?> someClass) {
        if (someClass.isAnnotationPresent(CustomAnnotation.class)) {
            CustomAnnotation annotation = someClass.getAnnotation(CustomAnnotation.class);

            System.out.println(String.format(OUTPUT, annotation.type(), annotation.descriotion()));
        }
    }
}
