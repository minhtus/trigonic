package binh.pc.trigonic.models;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ProductListConverter {

    @TypeConverter
    public String fromList(List<Product> products) {
        if (products == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Product>>() {}.getType();
        String json = gson.toJson(products, type);
        return json;
    }

    @TypeConverter
    public List<Product> toList(String products) {
        if (products == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Product>>() {}.getType();
        List<Product> countryLangList = gson.fromJson(products, type);
        return countryLangList;
    }
}
