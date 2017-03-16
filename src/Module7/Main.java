package Module7;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Order> list = createListOrders();
        sortingOrders(list);
        System.out.println("Unique cities are "+separateUniqueCity(list));
        System.out.println("Difference currency are "+separateCurrency(list));
        System.out.println("Price is less than "+priceIsLessThan(list, 1500));
        System.out.println("Duplicates are deleted "+duplicatesDelete(list));
        Set<Order> set = createSetOrders();
        System.out.println("Delete USD "+deleteUSD(set));
        System.out.println("The largest price is "+largestPrice(set));
        System.out.println("Petrov is present - "+checkUser(set, "Petrov"));
        System.out.println("\n---------------------------------------------------------------------------------------");
        System.out.println("Statistic ArrayList in comparison with LinkedLIst ");
        System.out.println("---------------------------------------------------------------------------------------\n");
        CompareArrayAnaLinkedList.compareAddInteger();
        CompareArrayAnaLinkedList.compareAddString();
        CompareArrayAnaLinkedList.compareSetInteger();
        CompareArrayAnaLinkedList.compareSetString();
        CompareArrayAnaLinkedList.compareGetInteger();
        CompareArrayAnaLinkedList.compareGetString();
        CompareArrayAnaLinkedList.compareRemoveInteger();
        CompareArrayAnaLinkedList.compareRemoveString();
    }

    static class CompareArrayAnaLinkedList{

        static void compareRemoveString(){
            List<String> linkedList;
            List<String> arrayList;
            long linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListString(1000);
            for (int i = 0; i < linkedList.size(); i++) {
                linkedList.remove(String.valueOf(i));
            }
            System.out.println("String LinkedLIst remove 1000 elements "+(System.currentTimeMillis() - linkedTime));
            long arrayTime = System.currentTimeMillis();
            arrayList = createArrayListString(1000);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.remove(String.valueOf(i));
            }
            System.out.println("String ArrayList remove 1000 elements "+(System.currentTimeMillis()-arrayTime));
            linkedList.clear();
            arrayList.clear();
            linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListString(10000);
            for (int i = 0; i < linkedList.size(); i++) {
                linkedList.remove(String.valueOf(i));
            }
            System.out.println("String LinkedLIst remove 10000 elements "+(System.currentTimeMillis() - linkedTime));
            arrayTime = System.currentTimeMillis();
            arrayList = createArrayListString(10000);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.remove(String.valueOf(i));
            }
            System.out.println("String ArrayList remove 10000 elements "+(System.currentTimeMillis()-arrayTime));
        }

        static void compareRemoveInteger(){
            List<Integer> linkedList;
            List<Integer> arrayList;
            long linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListInteger(1000);
            for (int i = 0; i < linkedList.size(); i++) {
                linkedList.remove(i);
            }
            System.out.println("Integer LinkedLIst remove 1000  elements "+(System.currentTimeMillis() - linkedTime));
            long arrayTime = System.currentTimeMillis();
            arrayList = createArrayListInteger(1000);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.remove(i);
            }
            System.out.println("Integer ArrayList remove 1000  elements "+(System.currentTimeMillis()-arrayTime));
            linkedList.clear();
            arrayList.clear();
            linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListInteger(10000);
            for (int i = 0; i < linkedList.size(); i++) {
                linkedList.remove(i);
            }
            System.out.println("Integer LinkedLIst remove 10000  elements "+(System.currentTimeMillis() - linkedTime));
            arrayTime = System.currentTimeMillis();
            arrayList = createArrayListInteger(10000);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.remove(i);
            }
            System.out.println("Integer ArrayList remove 10000  elements "+(System.currentTimeMillis()-arrayTime));
        }

        static void compareGetString(){
            List<String> linkedList;
            List<String> arrayList;
            long linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListString(1000);
            for (int i = 0; i < linkedList.size(); i++) {
                linkedList.get(i);
            }
            System.out.println("String LinkedLIst get 1000 elements "+(System.currentTimeMillis() - linkedTime));
            long arrayTime = System.currentTimeMillis();
            arrayList = createArrayListString(1000);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i);
            }
            System.out.println("String ArrayList get 1000 elements "+(System.currentTimeMillis()-arrayTime));
            linkedList.clear();
            arrayList.clear();
            linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListString(10000);
            for (int i = 0; i < linkedList.size(); i++) {
                linkedList.get(i);
            }
            System.out.println("String LinkedLIst get 10000 elements "+(System.currentTimeMillis() - linkedTime));
            arrayTime = System.currentTimeMillis();
            arrayList = createArrayListString(10000);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i);
            }
            System.out.println("String ArrayList get 10000 elements "+(System.currentTimeMillis()-arrayTime));
        }

        static void compareGetInteger(){
            List<Integer> linkedList;
            List<Integer> arrayList;
            long linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListInteger(1000);
            for (int i = 0; i < linkedList.size(); i++) {
                linkedList.get(i);
            }
            System.out.println("Integer LinkedLIst get 1000  elements "+(System.currentTimeMillis() - linkedTime));
            long arrayTime = System.currentTimeMillis();
            arrayList = createArrayListInteger(1000);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i);
            }
            System.out.println("Integer ArrayList get 1000  elements "+(System.currentTimeMillis()-arrayTime));
            linkedList.clear();
            arrayList.clear();
            linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListInteger(10000);
            for (int i = 0; i < linkedList.size(); i++) {
                linkedList.get(i);
            }
            System.out.println("Integer LinkedLIst get 10000  elements "+(System.currentTimeMillis() - linkedTime));
            arrayTime = System.currentTimeMillis();
            arrayList = createArrayListInteger(10000);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i);
            }
            System.out.println("Integer ArrayList get 10000  elements "+(System.currentTimeMillis()-arrayTime));
        }

        static void compareSetString(){
            List<String> linkedList;
            List<String> arrayList;
            long linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListString(1);
            for (int i = 0; i < 999; i++) {
                linkedList.set(linkedList.size()-1,String.valueOf(i));
            }
            System.out.println("String LinkedLIst set 1000  elements "+(System.currentTimeMillis() - linkedTime));
            long arrayTime = System.currentTimeMillis();
            arrayList = createArrayListString(1);
            for (int i = 0; i < 999; i++) {
                arrayList.set(arrayList.size()-1,String.valueOf(i));
            }
            System.out.println("String ArrayList set 1000  elements "+(System.currentTimeMillis()-arrayTime));
            linkedList.clear();
            arrayList.clear();
            linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListString(1);
            for (int i = 0; i < 9999; i++) {
                linkedList.set(linkedList.size()-1,String.valueOf(i));
            }
            System.out.println("String LinkedLIst set 10000  elements "+(System.currentTimeMillis() - linkedTime));
            arrayTime = System.currentTimeMillis();
            arrayList = createArrayListString(1);
            for (int i = 0; i < 9999; i++) {
                arrayList.set(arrayList.size()-1,String.valueOf(i));
            }
            System.out.println("String ArrayList set 10000  elements "+(System.currentTimeMillis()-arrayTime));
        }

        static void compareSetInteger(){
            List<Integer> linkedList;
            List<Integer> arrayList;
            long linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListInteger(1);
            for (int i = 0; i < 999; i++) {
                linkedList.set(linkedList.size()-1,i);
            }
            System.out.println("Integer LinkedLIst set 1000  elements "+(System.currentTimeMillis() - linkedTime));
            long arrayTime = System.currentTimeMillis();
            arrayList = createArrayListInteger(1);
            for (int i = 0; i < 999; i++) {
                arrayList.set(arrayList.size()-1,i);
            }
            System.out.println("Integer ArrayList set 1000  elements "+(System.currentTimeMillis()-arrayTime));
            linkedList.clear();
            arrayList.clear();
            linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListInteger(1);
            for (int i = 0; i < 9999; i++) {
                linkedList.set(linkedList.size()-1,i);
            }
            System.out.println("Integer LinkedLIst set 10000  elements "+(System.currentTimeMillis() - linkedTime));
            arrayTime = System.currentTimeMillis();
            arrayList = createArrayListInteger(1);
            for (int i = 0; i < 9999; i++) {
                arrayList.set(arrayList.size()-1,i);
            }
            System.out.println("Integer ArrayList set 10000  elements "+(System.currentTimeMillis()-arrayTime));
        }

        static void compareAddString(){
            List<String> linkedList;
            List<String> arrayList;
            long linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListString(1000);
            System.out.println("String LinkedLIst add 1000 elements "+(System.currentTimeMillis() - linkedTime));
            long arrayTime = System.currentTimeMillis();
            arrayList = createArrayListString(1000);
            System.out.println("String ArrayList add 1000 elements "+(System.currentTimeMillis()-arrayTime));
            linkedList.clear();
            arrayList.clear();
            linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListString(10000);
            System.out.println("String LinkedLIst add 10000 elements "+(System.currentTimeMillis() - linkedTime));
            arrayTime = System.currentTimeMillis();
            arrayList = createArrayListString(10000);
            System.out.println("String ArrayList add 10000 elements "+(System.currentTimeMillis()-arrayTime));
        }

        static void compareAddInteger(){
            List<Integer> linkedList;
            List<Integer> arrayList;
            long linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListInteger(1000);
            System.out.println("Integer LinkedLIst add 1000  elements "+(System.currentTimeMillis() - linkedTime));
            long arrayTime = System.currentTimeMillis();
            arrayList = createArrayListInteger(1000);
            System.out.println("Integer ArrayList add 1000  elements "+(System.currentTimeMillis()-arrayTime));
            linkedList.clear();
            arrayList.clear();
            linkedTime = System.currentTimeMillis();
            linkedList = createLinkedListInteger(10000);
            System.out.println("Integer LinkedLIst add 10000  elements "+(System.currentTimeMillis() - linkedTime));
            arrayTime = System.currentTimeMillis();
            arrayList = createArrayListInteger(10000);
            System.out.println("Integer ArrayList add 10000  elements "+(System.currentTimeMillis()-arrayTime));
        }

        private static LinkedList<Integer> createLinkedListInteger(int size){
            LinkedList<Integer> resultList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                resultList.add(i);
            }
            return resultList;
        }

        private static LinkedList<String> createLinkedListString(int size){
            LinkedList<String> resultList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                resultList.add(String.valueOf(i));
            }
            return resultList;
        }

        private static ArrayList<Integer> createArrayListInteger(int size){
            ArrayList<Integer> resultList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                resultList.add(i);
            }
            return resultList;
        }

        private static ArrayList<String> createArrayListString(int size){
            ArrayList<String> resultList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                resultList.add(String.valueOf(i));
            }
            return resultList;
        }
    }

    static boolean checkUser(Set<Order> inputSet, String surname){
        if (inputSet != null) {
            return inputSet.stream().filter(i -> i.getUser().getLastName().equals(surname)).findFirst().isPresent();
        }
        return false;
    }

    static Order largestPrice(Set<Order> inputSet){
        if (inputSet != null) {
            return inputSet.stream().max(ComparatorFactory.price().reversed()).get();
        }
        return new Order();
    }

    static Set<Order> deleteUSD(Set<Order> inputSet){
        if (inputSet != null) {
            return inputSet.stream().filter(i -> i.getCurrency().equals(Order.Currency.UAH)).collect(Collectors.toSet());
        }
        return new TreeSet<>();
    }

    static List<Order> duplicatesDelete(List<Order> inputList){
        if (inputList != null) {
            return new LinkedList<Order>(new HashSet<Order>(inputList));
        }
        return new LinkedList<>();
    }

    static List<Order> priceIsLessThan(List<Order> inputList, int price){
        if (inputList != null) {
            return   inputList.stream().filter(i -> i.getPrice() < price).collect(Collectors.toList());
        }
        return new LinkedList<>();
    }

    static List<List<Order>> separateCurrency(List<Order> inputList){
        List<List<Order>> resultList = new LinkedList<>();
        if (inputList != null) {
            List<Order> inputListCopy = new LinkedList<>(inputList);
            List<Order> listUAH = inputList.stream().filter(i -> i.getCurrency() == Order.Currency.UAH).collect(Collectors.toList());
            inputListCopy.removeAll(listUAH);
            resultList.add(listUAH);
            resultList.add(inputListCopy);
        }
        return resultList;
    }

    static List<List<Order>> separateUniqueCity(List<Order> inputList){
        List<List<Order>> resultList = new LinkedList<>();
        if (inputList != null) {
            HashSet<String> uniqueCities = new HashSet<>(inputList.stream().filter(i -> !(i.getUser().getCity().equals(""))).map(p -> p.getUser().getCity()).collect(Collectors.toSet()));
            for (String city : uniqueCities) {
                resultList.add(inputList.stream().filter(p -> p.getUser().getCity().equals(city)).collect(Collectors.toList()));
            }
        }
        return resultList;
    }

    static void sortingOrders(List <Order> inputLIst){
        if (inputLIst != null) {
            inputLIst.sort(ComparatorFactory.price());
            System.out.println("Price sorting "+inputLIst);
            inputLIst.sort(ComparatorFactory.priceCity());
            System.out.println("Price and City sorting "+inputLIst);
            inputLIst.sort(ComparatorFactory.itemShopCity());
            System.out.println("Item, Shop and City sorting "+inputLIst);
        }
    }

    static class ComparatorFactory {

        static Comparator<Order> price() {
            return (Order o1, Order o2) -> o1.getPrice() > o2.getPrice() ? -1 : 1;
        }

        static Comparator<Order> priceCity() {
            return (Order o1, Order o2) -> {
                if (!(o1.getPrice() == o2.getPrice())) return o1.getPrice() > o2.getPrice() ? 1 : -1;
                return o1.getUser().getCity().compareTo(o2.getUser().getCity());
            };
        }

        static Comparator<Order> itemShopCity() {
            return (Order o1, Order o2) -> {
                int result = o1.getItemName().compareTo(o2.getItemName());
                if (result == 0) result = o1.getShopIdentificator().compareTo(o2.getShopIdentificator());
                if (result == 0) result = o1.getUser().getCity().compareTo(o2.getUser().getCity());
                return result;
            };
        }
    }

    static List<Order> createListOrders() {
        List<Order> resultOrders = new LinkedList<>();
        resultOrders.add(new Order(1, 1000, Order.Currency.USD, "Jeans", "P&B", new User("Andy", "Sparrow", "Kiev", 1000)));
        resultOrders.add(new Order(2, 2000, Order.Currency.UAH, "Shirt", "Collins", new User("Andy", "Sparrow", "Lviv", 1000)));
        resultOrders.add(new Order(3, 3000, Order.Currency.USD, "Jeans", "Bershka", new User("Andy", "Sparrow", "Kiev", 1000)));
        resultOrders.add(new Order(4, 1000, Order.Currency.UAH, "Pen", "P&B", new User("Andy", "Sparrow", "Odessa", 1000)));
        resultOrders.add(new Order(5, 4000, Order.Currency.UAH, "Jacket", "Bershka", new User("Andy", "Sparrow", "Lviv", 1000)));
        resultOrders.add(new Order(6, 2000, Order.Currency.UAH, "Jeans", "Bershka", new User("Andy", "Sparrow", "Odessa", 1000)));
        resultOrders.add(new Order(7, 1000, Order.Currency.USD, "Bag", "Collins", new User("Andy", "Sparrow", "Odessa", 1000)));
        resultOrders.add(new Order(8, 3000, Order.Currency.UAH, "Shirt", "P&B", new User("Andy", "Sparrow", "Kiev", 1000)));
        resultOrders.add(new Order(9, 2000, Order.Currency.UAH, "Jeans", "Collins", new User("Andy", "Sparrow", "Lviv", 1000)));
        resultOrders.add(new Order(10, 1000, Order.Currency.USD, "Shoes", "P&B", new User("Andy", "Sparrow", "Kiev", 1000)));
        return resultOrders;
    }

    static Set<Order> createSetOrders() {
        Set<Order> resultOrders = new TreeSet<>();
        resultOrders.add(new Order(1, 1000, Order.Currency.USD, "Jeans", "P&B", new User("Andy", "Sparrow", "Kiev", 1000)));
        resultOrders.add(new Order(1, 1000, Order.Currency.USD, "Jeans", "P&B", new User("Andy", "Sparrow", "Kiev", 1000)));
        resultOrders.add(new Order(2, 2000, Order.Currency.UAH, "Shirt", "Collins", new User("Andy", "Sparrow", "Lviv", 1000)));
        resultOrders.add(new Order(2, 2000, Order.Currency.UAH, "Shirt", "Collins", new User("Andy", "Sparrow", "Lviv", 1000)));
        resultOrders.add(new Order(3, 3000, Order.Currency.USD, "Jeans", "Bershka", new User("Andy", "Sparrow", "Kiev", 1000)));
        resultOrders.add(new Order(4, 1000, Order.Currency.UAH, "Pen", "P&B", new User("Andy", "Sparrow", "Odessa", 1000)));
        resultOrders.add(new Order(5, 4000, Order.Currency.UAH, "Jacket", "Bershka", new User("Andy", "Sparrow", "Lviv", 1000)));
        resultOrders.add(new Order(6, 2000, Order.Currency.UAH, "Jeans", "Bershka", new User("Andy", "Sparrow", "Odessa", 1000)));
        resultOrders.add(new Order(7, 1000, Order.Currency.USD, "Bag", "Collins", new User("Andy", "Sparrow", "Odessa", 1000)));
        resultOrders.add(new Order(8, 3000, Order.Currency.UAH, "Shirt", "P&B", new User("Andy", "Sparrow", "Kiev", 1000)));
        return resultOrders;
    }
}

