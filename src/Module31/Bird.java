package Module31;

public class Bird    {

    public void sing(String word) {
        switch (word){
            case "walk":
                System.out.println("I am waliking");
                break;
            case "fly":
                System.out.println("I am flying");
                break;
            case "sing":
                System.out.println("I am singing");
                break;
            case "name":
                System.out.println("I am Bird");
                break;
            default:
                System.out.println("Wrong input value you must select one of this statements: walk, fly, sing, name");
        }
    }
}
