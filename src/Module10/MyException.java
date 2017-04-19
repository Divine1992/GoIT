package Module10;

public class MyException extends Exception {
    private String name;

    public MyException(){
    }

    public MyException(String name){
        this.name = name;
    }

    public void showName(){
        System.out.println("The name of MyException class is - "+name);
    }
}

class Task2 {

    public static void main(String[] args) {
        try {
            MyException myException = new MyException("It is a first my Exception");
            throw myException;
        } catch (MyException e){
            e.showName();
        }
    }
}

class Task3 {
    private String name;

    public Task3(){
    }

    public Integer getLenght(){
        return name.length();
    }

    public static void main(String[] args) {
        try{
            Task3 nullObject = new Task3();
            nullObject.getLenght();
        }catch (NullPointerException e) {
            System.err.println("We have a problem -> "+e);
        }
    }
}
