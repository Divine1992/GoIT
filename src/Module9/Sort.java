package Module9;

        import Module7.Order;

        import java.util.*;
        import java.util.stream.Collectors;

public class Sort {

    public static void sortByRevertPrice(List <Order> orders){
        if(orders == null){
            return;
        }
        List<Order> resultList = new ArrayList<>(orders);
        resultList.sort((Order o1,Order o2) -> -(o1.getPrice()-o2.getPrice()));
        System.out.println("Revert price list: "+resultList);
    }

    public static void sortByPriceAndCity(List<Order> orders){
        if(orders == null){
            return;
        }
        List<Order> resultList = new ArrayList<>(orders);
        resultList.sort((Order o1,Order o2) -> {
            int result = (o1.getPrice() - o2.getPrice());
            if (result == 0){
                return o1.getUser().getCity().compareTo(o2.getUser().getCity());
            }
            return result;
        });
        System.out.println("List sorted by price and city name: "+resultList);
    }

    public static void sortByItemShopCity(List<Order> orders){
        if(orders == null){
            return;
        }
        List<Order> resultList = new ArrayList<>(orders);
        resultList.sort((Order o1,Order o2) -> {
            int result = o1.getItemName().compareTo(o2.getItemName());
            if (result == 0) result = o1.getShopIdentificator().compareTo(o2.getShopIdentificator());
            if (result == 0) result = o1.getUser().getCity().compareTo(o2.getUser().getCity());
            return result;
        });
        System.out.println("Item, Shop and City sorting: "+resultList);
    }

    public static void deleteDuplicates(List<Order> orders){
        if (orders != null) {
            System.out.println("Unique list: "+new LinkedList<Order>(new HashSet<Order>(orders)));
        }
    }

    public static void deleteOrdersByPriceLess(List<Order> orders, Integer price){
        List<Order> resultList = orders;
        System.out.println("List without price less than "+price+": "+resultList.stream().filter(x -> x.getPrice() >= price).collect(Collectors.toList()));
    };

    public static void separateCurrency(List<Order> orders){
        List<List<Order>> resultList = new ArrayList<>();
        List<Order> listUAH = orders.stream().filter(x -> x.getCurrency().equals(Order.Currency.UAH)).collect(Collectors.toList());
        List<Order> listUSD  = orders.stream().filter(x -> x.getCurrency().equals(Order.Currency.USD)).collect(Collectors.toList());;
        resultList.add(listUAH);
        resultList.add(listUSD);
        System.out.println("Separated list to currency: "+resultList);
    }

    public static void uniqueCity(List<Order> orders){
        List<List<Order>> resultList = new ArrayList<>();
        Set<String> uniqueCity = new HashSet<>();
        orders.stream().forEach(x -> uniqueCity.add(x.getUser().getCity()));
        uniqueCity.stream().forEach(x -> {
            List<Order> list = orders.stream().filter(y -> y.getUser().getCity().equals(x)).collect(Collectors.toList());
            resultList.add(list);
        });
        System.out.println("Unique list of city's: "+resultList);
    }

    public static void checkSurname(Set<Order> orders, String surname){
        Optional<Order> optional = orders.stream().filter(x -> x.getUser().getLastName().equals(surname)).findAny();
        if (optional.isPresent()){
            System.out.println("User with surname "+surname+" is in system");
        } else System.out.println("User with surname "+surname+" isn't in system");
    }

    public static void deleteUSDOrders(Set<Order> orders){
        System.out.println("List after deleting USD Orders: "+orders.stream().filter(x -> x.getCurrency().equals(Order.Currency.UAH)).collect(Collectors.toSet()));
    }
}
