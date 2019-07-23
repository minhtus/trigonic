package binh.pc.trigonic.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "History")
public class ProductHistory implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String image;
    private String name;
    private String colors;
    private String category;
    private int price;
    private double size;
    private String branch;
    private double cond;

    public ProductHistory(String image, String name, String colors, String category, int price, double size, String branch, double cond) {
        this.image = image;
        this.name = name;
        this.colors = colors;
        this.category = category;
        this.price = price;
        this.size = size;
        this.branch = branch;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getCond() {
        return cond;
    }

    public void setCond(double cond) {
        this.cond = cond;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
