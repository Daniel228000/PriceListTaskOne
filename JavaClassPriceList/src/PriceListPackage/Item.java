package PriceListPackage;



public class Item {
    private String name;
   // private int code;
    private int priceOne;
    private int priceTwo;

    public Item (String name, int priceOne, int priceTwo) {
        this.name = name;
       // this.code = code;
        this.priceOne = priceOne;
        this.priceTwo = priceTwo;

    }

    public String getName() {
       return name;
    }
    public String getName(int code) {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   // public int getCode() {
   //     return code;
   // }
   // public void setCode(int code) {
   //     this.code = code;
   // }
    public int  getPriceOne() {
        return priceOne;
    }
    public int  getPriceOne(int code) {
        return priceOne;
    }
    public void  setPriceOne( int priceOne) {
        this.priceOne = priceOne;
    }
    public int  getPriceTwo() {
        return priceTwo;
    }
        public int  getPriceTwo(int code) {
            return priceTwo;
    }
    public void  setPriceTwo( int priceTwo) {
        this.priceTwo = priceTwo;
    }
    public Item call(int code) {
        return new Item(getName(code), getPriceOne(code),getPriceTwo(code) );
    }
    public double getDoublePrice(int priceOne, int priceTwo) {
        return (double) (priceOne + (double) (priceTwo) / 100);
    }
    public String getStringPriceItem(int code) {
        if (priceTwo < 100) {
            return priceOne + "." + priceTwo;
        } else {
            return priceOne + priceTwo / 100 + "." + priceTwo % 100;
        }
    }

















}