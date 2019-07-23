package binh.pc.trigonic.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.List;

@Entity
public class Order implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @TypeConverters(ProductListConverter.class)
    private List<Product> products;
    private String status;
    private String date;
    private String name;
    private String phone;
    private String address;
    private String payment;
    private int total;

    public static String PENDING = "Đang xác nhận";
    public static String DELIVERING = "Đang giao";
    public static String COMPLETED = "Đã giao";
    public static String CANCELED = "Đã huỷ";
    public static String PAYMENT_COD = "Thanh toán tiền mặt khi nhận hàng";
    public static String PAYMENT_MOMO = "Thanh toán bằng ví MoMo";

    public Order(List<Product> products, String status, String date, String name, String phone, String address, String payment, int total) {
        this.products = products;
        this.status = status;
        this.date = date;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.payment = payment;
        this.total = total;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
