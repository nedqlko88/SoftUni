package p01_harvesting_fields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    private static final String PRIVATE = "private";
    private static final String PROTECTED = "protected";
    private static final String PUBLIC = "public";
    private static final String ALL = "all";
    private static final String HARVEST = "HARVEST";


    public static void main(String[] args) throws ClassNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<?> aClass = Class.forName("p01_harvesting_fields.RichSoilLand");
        Field[] declaredFields = aClass.getDeclaredFields();


        String line;

        while (!HARVEST.equals(line = reader.readLine())) {

            printFieldsByModifier(declaredFields, line);
        }
    }

    private static void printFieldsByModifier(Field[] declaredFields, String line) {
        switch (line) {
            case PRIVATE:
                for (Field declaredField : declaredFields) {
                    int modifier = declaredField.getModifiers();
                    if (Modifier.isPrivate(modifier)) {
                        System.out.println(PRIVATE + " " + declaredField.getType().getSimpleName() + " " + declaredField.getName());
                    }
                }
                break;
            case PROTECTED:
                for (Field declaredField : declaredFields) {
                    int modifier = declaredField.getModifiers();
                    if (Modifier.isProtected(modifier)) {
                        System.out.println(PROTECTED + " " + declaredField.getType().getSimpleName() + " " + declaredField.getName());
                    }
                }
                break;
            case PUBLIC:
                for (Field declaredField : declaredFields) {
                    int modifier = declaredField.getModifiers();
                    if (Modifier.isPublic(modifier)) {
                        System.out.println(PUBLIC + " " + declaredField.getType().getSimpleName() + " " + declaredField.getName());
                    }
                }
                break;
            case ALL:
                for (Field declaredField : declaredFields) {

                        System.out.println(Modifier.toString(declaredField.getModifiers()) + " " + declaredField.getType().getSimpleName() + " " + declaredField.getName());
                }
                break;
        }
    }
}
