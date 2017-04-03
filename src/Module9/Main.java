package Module9;

import Module7.Order;

import java.util.List;
import java.util.Set;

import static Module7.Main.createListOrders;
import static Module7.Main.createSetOrders;
import static Module9.Sort.*;

public class Main {

    public static void main(String[] args) {
        List<Order> list = createListOrders();
        Set<Order> set = createSetOrders();
        sortList(list);
        activityWithList(list, 1500);
        activityWithSet(set, "Petrov");
    }
    
    static void activityWithList(List<Order> orders, Integer price){
        deleteDuplicates(orders);
        deleteOrdersByPriceLess(orders, price);
        separateCurrency(orders);
        uniqueCity(orders);
    }

    static void activityWithSet(Set<Order> orders, String surname){
        checkSurname(orders, surname);
        deleteUSDOrders(orders);
    }

    static void sortList(List<Order> list){
        sortByRevertPrice(list);
        sortByPriceAndCity(list);
        sortByItemShopCity(list);
    }
}
