package Module7;

public class Order implements Comparable<Order>{
    private long id;
    private int price;
    private Currency currency;
    private String itemName;
    private String shopIdentificator;
    private User user;

    @Override
    public int compareTo(Order o) {
        return this.getId() > o.getId() ? 1 : -1;
    }

    enum Currency {
        USD, UAH;
    }

    public Order(){

    }

    public Order(long id, int price, Currency currency, String itemName, String shopIdentificator, User user) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentificator = shopIdentificator;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Order)) return false;

        Order order = (Order) o;
        return order.id==id && order.price==price && order.currency.equals(currency)
                && order.itemName.equals(itemName) && order.shopIdentificator.equals(shopIdentificator) && order.user.equals(user);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = (int) (31 * result + id);
        result = 31 * result + price;
        result = 31 * result + currency.hashCode();
        result = 31 * result + itemName.hashCode();
        result = 31 * result + shopIdentificator.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getShopIdentificator() {
        return shopIdentificator;
    }

    public void setShopIdentificator(String shopIdentificator) {
        this.shopIdentificator = shopIdentificator;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", currency=" + currency +
                ", itemName='" + itemName + '\'' +
                ", shopIdentificator='" + shopIdentificator + '\'' +
                ", user=" + user +
                '}';
    }
}
