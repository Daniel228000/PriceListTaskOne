package Tests;

import PriceListPackage.Price;
import org.junit.Test;
import PriceListPackage.Item;
import PriceListPackage.PriceList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;


public class Tests {
    Item tvorog = new Item("Творог", new Price(12, 65));
    Item milk = new Item("Молоко", new Price(14, 40));
    Item meat = new Item("Мясо", new Price(3, 240));
    Item vodka = new Item("Водка", new Price (1, 666));
    Item cheese = new Item("Сыр", new Price (69, 320));
    @Test
    public void addItem() {
        Map<Integer, Item> items = new HashMap<>();
        items.put(75, meat);

        PriceList priceList = new PriceList(items);
        priceList.addItem(69, milk);
        priceList.addItem(3, vodka);

        assertTrue(priceList.addItem(1234, cheese));
        assertFalse(priceList.addItem(75, meat));
        assertEquals(milk, priceList.getItem(69));
        assertEquals(vodka, priceList.getItem(3));
    }
    @Test
    public void removeItem() {
        Map<Integer, Item> items = new HashMap<>();
        items.put(55, new Item("Tomato", new Price (30, 70)));
        items.put(66, new Item("Tomato", new Price (25, 90)));
        items.put(77, new Item("Tomato", new Price (3, 20)));
        items.put(58, new Item("Tomato", new Price (5, 40)));

        PriceList priceList = new PriceList(items);
        priceList.removeItem(55);
        priceList.removeItem(66);

        assertNull(priceList.getItem(55));
        assertNull(priceList.getItem(66));
        assertTrue(priceList.removeItem(77));
        assertFalse(priceList.removeItem(1209));

    }
    @Test
    public void changeName() {
        Map<Integer, Item> items = new HashMap<>();
        items.put(5, new Item("Oregano", new Price(1, 20)));
        items.put(6, new Item("Cake", new Price (540, 20)));
        items.put(7, new Item("Coffee", new Price (770, 80)));
        items.put(8, new Item("Tea", new Price(114, 10)));
        items.put(60, tvorog);

        PriceList priceList = new PriceList(items);
        priceList.changeName(5, "Originano");
        priceList.changeName(7, "Instant Coffee");

        assertEquals("Originano", priceList.getName(5));
        assertEquals("Cake", priceList.getName(6));
        assertEquals("Instant Coffee", priceList.getName(7));
        assertEquals("Tea", priceList.getName(8));
        assertTrue( priceList.changeName(60, "Tvorozhok"));
    }
    @Test
    public void ChangePrice(){
        Map<Integer, Item> items = new HashMap<>();
        items.put(22, new Item("Fanta", new Price(45, 20)));
        items.put(23, new Item("Coca-cola", new Price(52, 20)));
        items.put(24, new Item("Pepsi", new Price(49, 80)));
        items.put(25, new Item("Seven-up", new Price(50, 10)));

        PriceList priceList = new PriceList(items);
        priceList.changePrice(23, new Price(55, 50));
        priceList.changePrice(24, new Price(51, 90));


        assertEquals(new Price (45,20), priceList.getItem(22).getPrice());
        assertEquals(new Price (55,50), priceList.getItem(23).getPrice());
        assertEquals(new Price (51,90), priceList.getItem(24).getPrice());
        assertEquals(new Price (50,10), priceList.getItem(25).getPrice());
    }

    @Test
    public void sumOfItems() {
        Map<Integer, Item> items = new HashMap<>();
        items.put(91, new Item("Water", new Price(30, 20)));
        items.put(92, new Item("Peper", new Price(42, 70)));
        items.put(93, new Item("Wood", new Price(200, 80)));

        PriceList priceList = new PriceList(items);

        assertEquals(new Price (1004, 0), priceList.sumOfItems(93, 5));
        assertEquals( new Price (85,40), priceList.sumOfItems(92, 2));
    }
}
