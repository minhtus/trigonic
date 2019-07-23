package binh.pc.trigonic;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.database.AppDatabase;
import binh.pc.trigonic.models.CartAdapter;
import binh.pc.trigonic.models.Order;
import binh.pc.trigonic.models.OrderDetailAdapter;
import com.google.android.material.button.MaterialButton;

import java.text.DateFormat;
import java.util.Date;

public class OrderDetailActivity extends AppCompatActivity {
    private TextView txtName;
    private TextView txtPhone;
    private TextView txtAddress;
    private TextView txtPayment;
    private TextView txtTotal;
    private TextView txtOrderDate;

    private OrderDetailAdapter orderDetailAdapter;
    private RecyclerView orderDetailRecyclerView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> this.finish());

        Intent intent = this.getIntent();
        Order order = (Order) intent.getSerializableExtra("ORDER");
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtAddress = findViewById(R.id.txtAddress);
        txtPayment = findViewById(R.id.txtPayment);
        txtTotal = findViewById(R.id.txtTotal);
        txtOrderDate = findViewById(R.id.txtOrderDate);
        orderDetailRecyclerView = findViewById(R.id.recycler_order_detail);

        txtName.setText(order.getName());
        txtPhone.setText(order.getPhone());
        txtAddress.setText(order.getAddress());
        txtPayment.setText(order.getPayment());
        txtTotal.setText(String.format("₫%,d", order.getTotal()));
        Date date = new Date(order.getDate());
        txtOrderDate.setText(date.toLocaleString());

        orderDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        orderDetailAdapter = new OrderDetailAdapter(this, order.getProducts());
        orderDetailRecyclerView.setAdapter(orderDetailAdapter);

        if (Order.PENDING.equals(order.getStatus())) {
            MaterialButton btnCancel = new MaterialButton(this);
            btnCancel.setText("Huỷ đơn");
            btnCancel.setOnClickListener(v -> {
                order.setStatus(Order.CANCELED);
                AppDatabase.getInstance(this).orderDAO().update(order);
                Toast.makeText(this, "Đã huỷ đơn", Toast.LENGTH_LONG).show();
                this.finish();
            });
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            params.setMarginStart(dpToPx(15));
            params.setMarginEnd(dpToPx(15));
            btnCancel.setLayoutParams(params);
            RelativeLayout layout = findViewById(R.id.layout_order_detail);
            layout.addView(btnCancel);
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
