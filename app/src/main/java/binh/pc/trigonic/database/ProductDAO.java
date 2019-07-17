package binh.pc.trigonic.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import binh.pc.trigonic.models.Product;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert
    void insert(Product product);

    @Query("select * from Cart")
    List<Product> getAll();

    @Query("delete from Cart")
    void deleteAll();
}
