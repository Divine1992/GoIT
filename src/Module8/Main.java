package Module8;

public class Main {

    private static IManageSystemImpl iManageSystem;
    private static Food milk;

    public static void main(String [] args){
        createManageSystem();
        iManageSystem.delete(milk);
        iManageSystem.deleteById(3);
        System.out.println("Product with id 4 -> "+iManageSystem.get(4));
        System.out.println("Price of food milk "+iManageSystem.getPrice(milk));
        sortDatabase();
    }

    static void sortDatabase(){
        iManageSystem.printProductsSortedByPrice();
        System.out.println("Sorted products by prices: "+iManageSystem.getPrices());
        iManageSystem.printProductsSortedByName();
        System.out.println("Sorted products by names: "+iManageSystem.getProducts());
    }

    static void createManageSystem(){
        iManageSystem = new IManageSystemImpl();
        milk = new Food("Milk", Country.Ukraine, 12);
        iManageSystem.save(milk, 120.5);
        iManageSystem.save(new Food("Tea", Country.China, 150), 20);
        iManageSystem.save(new Food("Bread", Country.France, 5), 220.6);
        iManageSystem.save(new Food("Oil", Country.Japan, 60), 80.3);
        iManageSystem.save(new Food("Meat", Country.GB, 4), 170);
        iManageSystem.save(new Food("Corn", Country.USA, 40), 90);
    }
}
