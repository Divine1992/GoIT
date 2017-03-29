package Module8;

public final class IdGenerator {
    private static int id = 0;

    private IdGenerator(){
    }

    public static int generateId(){
        return ++id;
    }
}