package binh.pc.trigonic.models;

public class Product {
    private int image;
    private String name;
    private String colors;
    private String category;
    private int price;
    private double cond;

    public Product(int image, String name, String colors, String category, int price, double cond) {
        this.image = image;
        this.name = name;
        this.colors = colors;
        this.category = category;
        this.price = price;
        this.cond = cond;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getCond() {
        return cond;
    }

    public void setCond(double cond) {
        this.cond = cond;
    }
}
