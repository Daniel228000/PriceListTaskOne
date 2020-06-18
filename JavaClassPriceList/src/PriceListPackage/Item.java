package PriceListPackage;

public class Item {
    private String name;
    private Price price;

    public Item (String name, Price price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
       return name;
    }
    public Price getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Price price) {
        this.price = price;
    }
}