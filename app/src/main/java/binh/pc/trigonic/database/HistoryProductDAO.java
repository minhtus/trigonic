package binh.pc.trigonic.database;

import androidx.room.*;

import java.util.List;

import binh.pc.trigonic.models.Product;
import binh.pc.trigonic.models.ProductHistory;

@Dao
public interface HistoryProductDAO {
    @Insert
    void insert(ProductHistory productHistory);

    @Query("select * from History order by id desc")
    List<ProductHistory> getAll();

    @Update
    void update(ProductHistory productHistory);

    @Delete
    void delete(ProductHistory productHistory);

    @Query("delete from History")
    void deleteAll();
}
