package binh.pc.trigonic;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import binh.pc.trigonic.database.AppDatabase;
import binh.pc.trigonic.models.Order;
import binh.pc.trigonic.models.Product;
import com.google.android.material.textfield.TextInputEditText;

import java.time.Instant;
import java.util.Calendar;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private TextInputEditText edtPhone;
    private TextInputEditText edtName;
    private TextInputEditText edtAddress;
    private Button btnOrder;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> this.finish());

        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtAddress = findViewById(R.id.edtAddress);
        btnOrder = findViewById(R.id.btnOrder);

        SharedPreferences sharedPreferences =
                getSharedPreferences(getString(R.string.login_shared_prefs), Context.MODE_PRIVATE);
        edtName.setText(sharedPreferences.getString(getString(R.string.name_shared_prefs), ""));
        edtPhone.setText(sharedPreferences.getString(getString(R.string.phone_shared_prefs), ""));
        edtAddress.setText(sharedPreferences.getString(getString(R.string.address_shared_prefs), ""));

        btnOrder.setOnClickListener(v -> {
            AppDatabase database = AppDatabase.getInstance(this);
            List<Product> products = database.cartDAO().getAll();
            int total = products.stream().map(Product::getPrice).reduce(Integer::sum).get();
            database.orderDAO().insert(new Order(products, Order.PENDING,
                    Calendar.getInstance().getTimeInMillis(),
                    edtName.getText().toString() , edtPhone.getText().toString(),
                    edtAddress.getText().toString(), Order.PAYMENT_COD , total));
            Toast.makeText(this, "Đặt hàng thành công", Toast.LENGTH_LONG).show();
            database.cartDAO().deleteAll();
            this.finish();
            Intent intent = new Intent(this, OrderHistoryActivity.class);
            startActivity(intent);
        });
    }
}
