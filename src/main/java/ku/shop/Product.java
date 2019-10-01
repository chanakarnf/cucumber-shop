package ku.shop;

public class Product {
    private double price;
    private String name;
    private int num;

    public Product(String name, double price,int num) {
        this.name = name;
        this.price = price;
        this.num = num;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) throws NotEnoughProductException{
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price must be not be negative zero");
        this.price = price;
    }
}
