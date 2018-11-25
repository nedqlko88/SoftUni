package DemoEnums;

public class Main {
    public static void main(String[] args) {
    MyEnum[] enums = MyEnum.values();

        for (MyEnum anEnum : enums) {
            System.out.println(anEnum);
        }
    }
}
