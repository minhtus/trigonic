package binh.pc.trigonic.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import binh.pc.trigonic.models.Product;
import binh.pc.trigonic.models.ProductHistory;

@Dao
public interface HistoryProductDAO {
    @Insert
    void insert(ProductHistory productHistory);

    @Query("select * from History")
    List<ProductHistory> getAll();

    @Delete
    void delete(ProductHistory productHistory);

    @Query("delete from History")
    void deleteAll();
}
