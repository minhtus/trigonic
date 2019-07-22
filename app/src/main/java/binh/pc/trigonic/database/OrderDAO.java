package binh.pc.trigonic.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import binh.pc.trigonic.models.Order;

import java.util.List;

@Dao
public interface OrderDAO {
    @Insert
    void insert(Order order);

    @Query("select * from `order`")
    List<Order> getAll();
}
