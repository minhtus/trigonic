package binh.pc.trigonic;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.models.ImageAdapter;
import com.esafirm.imagepicker.model.Image;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubmitProductActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtCondition;
    private EditText edtSize;
    private EditText edtPrice;
    private RecyclerView imageRecyclerView;
    private ImageAdapter imageAdapter;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_product);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> this.finish());

        imageRecyclerView = findViewById(R.id.recycler_images);
        imageRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        Intent intent = this.getIntent();
        imageAdapter = new ImageAdapter(this, intent.getParcelableArrayListExtra("IMAGES"));
        imageRecyclerView.setAdapter(imageAdapter);
        edtName = findViewById(R.id.edtName);
        edtCondition = findViewById(R.id.edtCondition);
        edtSize = findViewById(R.id.edtSize);
        edtPrice = findViewById(R.id.edtPrice);

        List<String> brandLists = new ArrayList<>(Arrays.asList("Adidas", "Alexander McQueen", "Balenciaga",
                "Balmain", "Boss Hugo Boss", "Bulgari", "Burberry", "Cartier", "Dior", "Dolce & Gabbana",
                "Dr.Martens", "Dsquared2", "Fendi", "Geox", "Givenchy", "Greg Lauren", "Gucci", "Guidi",
                "Hermès", "Jimmy Choo", "Kenzo", "Louis Vuitton", "Levi's", "Marc By Marc Jacobs",
                "MCM", "McQ Alexander McQueen", "Moschino", "Neil Barrett", "New Balance", "Nike",
                "Oakley", "Off-White", "Palm Angels", "Philipp Plein", "Prada", "Puma", "Raf Simons",
                "Rick Owen", "Supreme", "The North Face (TNF)", "Thom Browne", "Tom Ford", "Vans",
                "Venyx", "Versace", "Vogue", "Valentino"));

        Spinner brand = findViewById(R.id.brand);
        ArrayAdapter<String> brandAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, brandLists);
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brand.setAdapter(brandAdapter);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(v -> {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            String productName = edtName.getText().toString();
            String condition = edtCondition.getText().toString();
            String size = edtSize.getText().toString();
            Float price = Float.parseFloat(edtPrice.getText().toString());
            String tax = null;
            Float truePrice = null;
            if(price <= 10000000){
                tax = "5%";
                truePrice = (price*5)/100 + price;
            }
            if(price <= 20000000 && price > 10000000){
                tax = "3%";
                truePrice = (price*3)/100 + price;
            }
            if(price > 20000000){
                tax = "1%";
                truePrice = (price*1)/100 + price;
            }

//
//            Map<String,Object> products = new HashMap<>();
//            products.put("Brand", "Nike");
//            products.put("Product", productName);
//            products.put("Condition", condition);
//            products.put("Size", size);
//            products.put("Your Price", price);
//            products.put("Tax", tax);
//            products.put("Price", truePrice);
//
//            db.collection("CusProduct").add(products)
//                    .addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId()))
//                    .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));

        });
    }

}
