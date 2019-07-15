package binh.pc.trigonic;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.*;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class LoggedSellFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    private EditText editProduct;
    private EditText editCondition;
    private EditText editSize;
    private EditText editPrice;
    private TextView txtTax;
    private TextView txtTruePrice;


    public LoggedSellFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logged_sell, container, false);
        editProduct = view.findViewById(R.id.editProduct);
        editCondition = view.findViewById(R.id.editCondition);
        editSize = view.findViewById(R.id.editSize);
        editPrice = view.findViewById(R.id.editPrice);
        txtTax = view.findViewById(R.id.txtTax);
        txtTruePrice = view.findViewById(R.id.txtTruePrice);

        List<String> brandLists = new ArrayList<>(Arrays.asList("Adidas", "Alexander McQueen", "Balenciaga",
                "Balmain", "Boss Hugo Boss", "Bulgari", "Burberry", "Cartier", "Dior", "Dolce & Gabbana",
                "Dr.Martens", "Dsquared2", "Fendi", "Geox", "Givenchy", "Greg Lauren", "Gucci", "Guidi",
                "Hermès", "Jimmy Choo", "Kenzo", "Louis Vuitton", "Levi's", "Marc By Marc Jacobs",
                "MCM", "McQ Alexander McQueen", "Moschino", "Neil Barrett", "New Balance", "Nike",
                "Oakley", "Off-White", "Palm Angels", "Philipp Plein", "Prada", "Puma", "Raf Simons",
                "Rick Owen", "Supreme", "The North Face (TNF)", "Thom Browne", "Tom Ford", "Vans",
                "Venyx", "Versace", "Vogue", "Valentino"));

        Spinner brand = view.findViewById(R.id.brand);
        ArrayAdapter<String> brandAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, brandLists);

        // Drop down layout style - list view with radio button
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        brand.setAdapter(brandAdapter);

        Button button = view.findViewById(R.id.btnAdd);
        button.setOnClickListener(v -> {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            String product = editProduct.getText().toString();
            String condition = editCondition.getText().toString();
            String size = editSize.getText().toString();
            Float price = Float.parseFloat(editPrice.getText().toString());
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


            Map<String,Object> products = new HashMap<>();
            products.put("Brand", "Nike");
            products.put("Product",product);
            products.put("Condition", condition);
            products.put("Size", size);
            products.put("Your Price", price);
            products.put("Tax", tax);
            products.put("Price", truePrice);

            db.collection("CusProduct").add(products)
                    .addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId()))
                    .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));

        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
