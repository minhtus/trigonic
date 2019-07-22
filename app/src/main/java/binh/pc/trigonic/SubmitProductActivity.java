package binh.pc.trigonic;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.models.ImageAdapter;
import binh.pc.trigonic.utils.CurrencyTextWatcher;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.NumberFormat;
import java.util.*;

public class SubmitProductActivity extends AppCompatActivity {
    private TextInputEditText edtName;
    private TextInputEditText edtCondition;
    private TextInputEditText edtSize;
    private TextInputEditText edtPrice;
    private RecyclerView imageRecyclerView;
    private ImageAdapter imageAdapter;
    private Button btnSubmit;
    private AutoCompleteTextView edtBranch;
    private static final String TAG = "SubmitProductActivity";

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
        edtPrice.addTextChangedListener(new CurrencyTextWatcher(edtPrice, "₫"));

        List<String> brandLists = new ArrayList<>(Arrays.asList("Adidas", "Alexander McQueen", "Balenciaga",
                "Balmain", "Boss Hugo Boss", "Bulgari", "Burberry", "Cartier", "Dior", "Dolce & Gabbana",
                "Dr.Martens", "Dsquared2", "Fendi", "Geox", "Givenchy", "Greg Lauren", "Gucci", "Guidi",
                "Hermès", "Jimmy Choo", "Kenzo", "Louis Vuitton", "Levi's", "Marc By Marc Jacobs",
                "MCM", "McQ Alexander McQueen", "Moschino", "Neil Barrett", "New Balance", "Nike",
                "Oakley", "Off-White", "Palm Angels", "Philipp Plein", "Prada", "Puma", "Raf Simons",
                "Rick Owen", "Supreme", "The North Face (TNF)", "Thom Browne", "Tom Ford", "Vans",
                "Venyx", "Versace", "Vogue", "Valentino"));


        ArrayAdapter<String> brandAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, brandLists);
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edtBranch = findViewById(R.id.edtBranch);
        edtBranch.setAdapter(brandAdapter);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(v -> {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            String productName = edtName.getText().toString();
            String condition = edtCondition.getText().toString();
            String size = edtSize.getText().toString();
            String brand = edtBranch.getText().toString();
            Float price = Float.parseFloat(edtPrice.getText().toString());
            String rate = null;
            Float fee = null;
            if (price <= 10000000) {
                rate = "5%";
                fee = (price * 5) / 100;
            }
            if (price <= 20000000 && price > 10000000) {
                rate = "3%";
                fee = (price * 3) / 100;
            }
            if (price > 20000000) {
                rate = "1%";
                fee = (price * 1) / 100;
            }


            Map<String, Object> products = new HashMap<>();
            products.put("Brand", brand);
            products.put("Product", productName);
            products.put("Condition", condition);
            products.put("Size", size);
            products.put("Price", price);
            products.put("Rate", rate);
            products.put("Fee", fee);

            db.collection("CusProduct").add(products)
                    .addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId()))
                    .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));

        });
    }

}
