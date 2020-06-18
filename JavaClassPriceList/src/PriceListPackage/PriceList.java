package PriceListPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PriceList {

    private Map<Integer, Item> priceList;

    public PriceList() {
        priceList = new HashMap<Integer, Item>();
    }

    public PriceList(Map<Integer, Item> priceList) {
        this.priceList = new HashMap<Integer, Item>(priceList);
    }


    public boolean changePrice(int code, Price price) {
        boolean flag = false;
        Item item = priceList.get(code);
        if (item != null) {
            item.setPrice(price);
            flag = true;
        }
        return flag;
    }

    public boolean changeName(int code, String newName) {
        Item item = priceList.get(code);
        boolean flag = false;
        if ((item != null) & (!item.getName().equals(newName))) {
            item.setName(newName);
            flag = true;
        }
        return flag;
    }




    public boolean addItem(int code, Item item) {
        return priceList.putIfAbsent(code, item) == null;
    }

    public boolean removeItem(int code) {
        return priceList.remove(code) != null;
    }

    public Price sumOfItems(int code, int quantity) {
        Price price = new Price(0,0);
        Item item = priceList.get(code);
        if (item == null) throw  new IllegalArgumentException("No product with this code");
        return new Price(item.getPrice().getPriceByKopecks() * quantity);

    }

    public Item getItem(int code) {
        return priceList.get(code);
    }

    public String getName(int code) {
        Item item = priceList.get(code);
        if (item != null) {
            return item.getName();
        } else throw new IllegalArgumentException("No item for this key");
    }
}
