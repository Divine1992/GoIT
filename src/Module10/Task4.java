package Module10;

public class Task4 {

    private static void g() throws MyException {
        throw new MyException("MyException");
    }

    private static void f() throws Exception {
        try {
            g();
        } catch (MyException e) {
            throw new Exception();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (MyException e) {
            System.out.println("I caught "+e);
        }
        try {
            f();
        } catch (Exception e) {
            System.out.println("I caught "+e);
        }
    }
}
