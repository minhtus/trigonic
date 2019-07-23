package binh.pc.trigonic.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import binh.pc.trigonic.models.Order;
import binh.pc.trigonic.models.Product;
import binh.pc.trigonic.models.ProductHistory;

@Database(entities = {Product.class, Order.class, ProductHistory.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CartDAO cartDAO();
    public abstract OrderDAO orderDAO();
    public abstract HistoryProductDAO historyProductDAO();
    public static AppDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "AppDatabase")
                .allowMainThreadQueries()
                .build();
    }
}
