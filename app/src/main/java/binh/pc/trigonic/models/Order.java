package binh.pc.trigonic.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.List;

@Entity
public class Order {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @TypeConverters(ProductListConverter.class)
    private List<Product> products;
    private String status;
    private String date;

    public static String ORDER_PENDING = "Đang xác nhận";
    public static String DELIVERING = "Đang giao";
    public static String COMPLETED = "Đã giao";
    public static String CANCELED = "Đã huỷ";

    public Order(List<Product> products, String status, String date) {
        this.products = products;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
