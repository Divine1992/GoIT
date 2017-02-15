package Module31;

public class Test {

    private static void testBird(String word){
        Bird bird = new Bird();
        bird.sing(word);
    }

    public static void main(String[] args) {
        testBird("I am walking");
        testBird("I am flying");
        testBird("I am singing");
        testBird("I am Bird");
    }

}
