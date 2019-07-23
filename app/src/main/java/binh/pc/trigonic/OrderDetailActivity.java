package binh.pc.trigonic;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.models.CartAdapter;
import binh.pc.trigonic.models.Order;
import binh.pc.trigonic.models.OrderDetailAdapter;

public class OrderDetailActivity extends AppCompatActivity {
    private TextView txtName;
    private TextView txtPhone;
    private TextView txtAddress;
    private TextView txtPayment;
    private TextView txtTotal;

    private OrderDetailAdapter orderDetailAdapter;
    private RecyclerView orderDetailRecyclerView;

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
        orderDetailRecyclerView = findViewById(R.id.recycler_order_detail);

        txtName.setText(order.getName());
        txtPhone.setText(order.getPhone());
        txtAddress.setText(order.getAddress());
        txtPayment.setText(order.getPayment());
        txtTotal.setText(String.format("₫%,d", order.getTotal()));

        orderDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        orderDetailAdapter = new OrderDetailAdapter(this, order.getProducts());
        orderDetailRecyclerView.setAdapter(orderDetailAdapter);


    }
}
