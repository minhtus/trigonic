package binh.pc.trigonic.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import binh.pc.trigonic.models.Product;
import binh.pc.trigonic.models.ProductHistory;

@Database(entities = {Product.class, ProductHistory.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDAO productDAO();
    public abstract HistoryProductDAO historyProductDAO();

    public static AppDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "AppDatabase")
                .allowMainThreadQueries()
                .build();
    }
}
