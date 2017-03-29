package Module8;

import java.util.*;

public class IManageSystemImpl implements IManageSystem<Food>{
    private Map<Food, Double> database = new LinkedHashMap<Food, Double>();

    @Override
    public Food save(Food food, double price) {
        database.put(food, price);
        return food;
    }

    @Override
    public Food save(Food food) {
        database.put(food, 0.0);
        return food;
    }

    @Override
    public void delete(Food food) {
        database.remove(food);
    }

    @Override
    public void deleteById(int id) {
        for (Iterator<Map.Entry<Food, Double>> iter = database.entrySet().iterator(); iter.hasNext();) {
            if (iter.next().getKey().getId() == id) {
                iter.remove();
            }
        }
    }

    @Override
    public Food get(int id) {
        for (Food food: database.keySet()) {
            if (food.getId() == id) {
                return food;
            }
        }
        return new Food();
    }

    @Override
    public Double getPrice(Food food) {
        if (database.get(food) == null) {
            return 0.0;
        }
        return database.get(food);
    }

    @Override
    public Set<Food> getProducts() {
        return new LinkedHashSet<Food>(database.keySet());
    }

    @Override
    public List<Double> getPrices() {
        return new ArrayList<Double>(database.values());
    }

    @Override
    public void printProductsSortedByName() {
        List<Map.Entry<Food, Double>> list = new ArrayList<>(database.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Food, Double>>() {
            @Override
            public int compare(Map.Entry<Food, Double> o1, Map.Entry<Food, Double> o2) {
                return o1.getKey().getName().compareTo(o2.getKey().getName());
            }
        });
        database.clear();
        for (Map.Entry<Food, Double> mapEntry: list) {
            database.put(mapEntry.getKey(), mapEntry.getValue());
        }
    }

    @Override
    public void printProductsSortedByPrice() {
        List<Map.Entry<Food, Double>> list = new ArrayList<>(database.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Food, Double>>() {
            @Override
            public int compare(Map.Entry<Food, Double> o1, Map.Entry<Food, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        database.clear();
        for (Map.Entry<Food, Double> mapEntry: list) {
            database.put(mapEntry.getKey(), mapEntry.getValue());
        }
    }
}

