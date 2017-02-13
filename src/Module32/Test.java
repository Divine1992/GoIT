package Module32;

public class Test {

    public static void main(String[] args) {
        test(2_000_000_000, 1);
    }

    private static void test(Integer a, Integer b) {
        Adder adder = new Adder();
        System.out.println(adder.add(a, b));
        System.out.println(adder.check(a, b));
    }
}
