package binh.pc.trigonic;

import android.content.Intent;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import binh.pc.trigonic.models.Product;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class DetailProductActivity extends AppCompatActivity {
    private ImageView back;
    private TextView txtCategory;
    private TextView txtPrice;
    private TextView txtName;
    private ImageView image;
    private TextView txtColor;
    private TextView txtCond;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        back = findViewById(R.id.imgBack);
        back.setOnClickListener(v -> this.finish());
        Intent intent = this.getIntent();
        Product product = (Product) intent.getSerializableExtra("PRODUCT");
        txtCategory = findViewById(R.id.txtCategory);
        txtCategory.setText(product.getCategory());
        txtPrice = findViewById(R.id.txtPrice);
        txtPrice.setText(String.format("₫%,d", product.getPrice()));
        txtName = findViewById(R.id.txtName);
        txtName.setText(product.getName());
        txtColor = findViewById(R.id.txtColor);
        txtColor.setText(String.format("Colors: %s", product.getColors()));
        txtCond = findViewById(R.id.txtCond);
        txtCond.setText(String.format("Cond: %.1f", product.getCond()));
        image = findViewById(R.id.image);
        Glide.with(this)
                .load(product.getImage())
                .into(image);
    }

}
