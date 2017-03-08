package Module6.Module6_4;

public class CitizenMain {

    public static void main(String[] args) {
        Citizen[] citizens = createCitizens();
        for (Citizen citizen : citizens) {
            citizen.sayHello();
        }
    }

    private static Citizen[] createCitizens(){
        Citizen englishMan = CitizenFactory.createEnglishMan();
        Citizen chineseMan = CitizenFactory.createChineseMan();
        Citizen russianMan = CitizenFactory.createRussianMan();
        Citizen italianMan = CitizenFactory.createItalianMan();
        return new Citizen[]{englishMan,chineseMan,russianMan,italianMan};
    }
}
