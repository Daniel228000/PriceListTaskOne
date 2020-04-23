package PriceListPackage;

import java.util.HashMap;
import java.util.Map;

public class PriceList {

    private Map<Integer, Item> priceList;

    public PriceList() {
        priceList = new HashMap<Integer, Item>();
    }
    public PriceList( Map<Integer, Item> priceList) {
        this.priceList = new HashMap<Integer, Item>(priceList);
    }


    public boolean changePrice(int code, int newPriceOne, int newPriceTwo) {
        boolean flag = false;
        Item item = priceList.get(code);
        if (item != null) {
            item.setPriceOne(newPriceOne);
            item.setPriceTwo(newPriceTwo);
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
        if (priceList.containsKey(code)) {
            return false;
        } else {
            priceList.putIfAbsent(code, item);
            return true;
        }
    }

    public boolean removeItem(int code) {
        return priceList.remove(code) != null;
    }

    public String sumOfItems(int code, int quantity) {
        int sumOne;
        int sumTwo;
        Item item = priceList.get(code);
        if (item == null) return "0.0";
        sumOne = item.getPriceOne() * quantity + item.getPriceTwo() * quantity / 100 - item.getPriceTwo() / 100 % 100 ;
        sumTwo = (item.getPriceTwo() * quantity - ((sumOne - item.getPriceOne() * quantity) * 100)) % 100;
        return sumOne + "." + sumTwo;
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

    public String getStringPrice(int code) {
        Item item = priceList.get(code);
        if (item.getPriceTwo() < 100) {
            return item.getPriceOne() + "." + item.getPriceTwo();
        } else {
            return item.getPriceOne() + item.getPriceTwo() / 100 + "." + item.getPriceTwo() % 100;
        }
    }
}
