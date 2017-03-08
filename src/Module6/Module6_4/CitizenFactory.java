package Module6.Module6_4;

public class CitizenFactory {

    private static class Englishman implements Citizen {

        @Override
        public void sayHello() {
            System.out.println("Hello I am from England");
        }
    }

    private static class Chinese implements Citizen {

        @Override
        public void sayHello() {
            System.out.println("Hello I am from China");
        }
    }

    private static class Russian implements Citizen {

        @Override
        public void sayHello() {
            System.out.println("Hello I am from Russia");
        }
    }

    private static class Italian implements Citizen {

        @Override
        public void sayHello() {
            System.out.println("Hello I am from Italy");
        }
    }

    public static Englishman createEnglishMan(){
        return new Englishman();
    }

    public static Chinese createChineseMan(){
        return new Chinese();
    }

    public static Russian createRussianMan(){
        return new Russian();
    }

    public static Italian createItalianMan(){
        return new Italian();
    }
}
