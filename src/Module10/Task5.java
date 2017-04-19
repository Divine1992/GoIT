package Module10;

import java.io.IOException;
import java.sql.SQLException;

public class Task5 {

    private static void throwMyAllExceptions() throws FirstException, SecondException, ThirdException {
        if (true){
            throw new FirstException();
        }
        if (true){
            throw new SecondException();
        }
        if (true){
            throw new ThirdException();
        }
    }

    public static void main(String[] args) {
        try {
            throwMyAllExceptions();
        } catch (FirstException| SecondException| ThirdException e) {
            e.printStackTrace();
        }
    }

}

class FirstException extends MyException{
}
class SecondException extends SQLException{
}
class ThirdException extends IOException{
}

