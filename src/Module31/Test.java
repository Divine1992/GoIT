package Module31;

public class Test {

    private static void testBird(String word){
        Bird bird = new Bird();
        bird.sing(word);
    }

    public static void main(String[] args) {
        testBird("fly");
    }

}
