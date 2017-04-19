package Module10;

public class Task1 {

    public static void main(String[] args) {
        try {
            Exception exception = new Exception("This is my exception");
            throw exception;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("Finally block");
        }
    }

}
