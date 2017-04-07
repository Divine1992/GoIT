package Module9;

        import Module7.Order;

        import java.util.*;
        import java.util.stream.Collectors;

public class Sort {

    public static void sortByRevertPrice(List <Order> orders){
        if(orders != null){
            List<Order> resultList = orders;
            resultList.sort(Comparator.comparing(Order::getPrice).reversed());
            System.out.println("Revert price list: "+resultList);
        }
    }

    public static void sortByPriceAndCity(List<Order> orders){
        if (orders != null){
            List<Order> resultList = orders;
            resultList.sort(Comparator.comparing(Order::getPrice).thenComparing(Comparator.comparing(o -> o.getUser().getCity())));
            System.out.println("List sorted by price and city name: "+resultList);
        }
    }

    public static void sortByItemShopCity(List<Order> orders){
        if(orders != null){
            List resultList = new ArrayList<>(orders);
            resultList.sort(Comparator.comparing(Order::getItemName).thenComparing(Order::getShopIdentificator)
                    .thenComparing(Comparator.comparing(o -> o.getUser().getCity())));
            System.out.println("Item, Shop and City sorting: "+resultList);
        }
    }

    public static void deleteDuplicates(List<Order> orders){
        if (orders != null) {
            System.out.println("Unique list: "+orders.stream().distinct().collect(Collectors.toList()));
        }
    }

    public static void deleteOrdersByPriceLess(List<Order> orders, Integer price){
        List<Order> resultList = orders;
        System.out.println("List without price less than "+price+": "+resultList.stream().filter(x -> x.getPrice() >= price).collect(Collectors.toList()));
    }

    public static void separateCurrency(List<Order> orders){
        List<List<Order>> resultList = new ArrayList<>();
        List<Order> listUAH = orders.stream().filter(x -> x.getCurrency().equals(Order.Currency.UAH)).collect(Collectors.toList());
        List<Order> listUSD  = orders.stream().filter(x -> x.getCurrency().equals(Order.Currency.USD)).collect(Collectors.toList());;
        resultList.add(listUAH);
        resultList.add(listUSD);
        System.out.println("Separated list to currency: "+resultList);
    }

    public static void uniqueCity(List<Order> orders){
        if(orders != null){
            List<Order> resulList = orders;
            Map<String, List<Order>> result = resulList.stream().collect(Collectors.groupingBy(o -> o.getUser().getCity()));
            System.out.println("Unique list of city's: "+result);
        }
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
