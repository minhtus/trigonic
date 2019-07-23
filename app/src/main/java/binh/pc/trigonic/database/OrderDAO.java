package binh.pc.trigonic.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import binh.pc.trigonic.models.Order;

import java.util.List;

@Dao
public interface OrderDAO {
    @Insert
    void insert(Order order);

    @Update
    void update(Order order);

    @Query("select * from `order`")
    List<Order> getAll();

    @Query("select * from `order` where status == :status")
    List<Order> getByStatus(String status);
}
