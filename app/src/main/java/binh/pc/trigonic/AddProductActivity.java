package binh.pc.trigonic;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class AddProductActivity extends Fragment implements AdapterView.OnItemSelectedListener{
    EditText editProduct;
    EditText editCondition;
    EditText editSize;
    EditText editPrice;
    TextView txtTax;
    TextView txtTruePrice;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_product, null);

        editProduct = view.findViewById(R.id.editProduct);
        editCondition = view.findViewById(R.id.editCondition);
        editSize = view.findViewById(R.id.editSize);
        editPrice = view.findViewById(R.id.editPrice);
        txtTax = view.findViewById(R.id.txtTax);
        txtTruePrice = view.findViewById(R.id.txtTruePrice);

        Spinner brand = (Spinner) view.findViewById(R.id.brand);
        List<String> brandLists = new ArrayList<String>();
        brandLists.add("Adidas");
        brandLists.add("Alexander McQueen");
        brandLists.add("Balenciaga");
        brandLists.add("Balmain");
        brandLists.add("Boss Hugo Boss");
        brandLists.add("Bulgari");
        brandLists.add("Burberry");
        brandLists.add("Cartier");
        brandLists.add("Dior");
        brandLists.add("Dolce & Gabbana");
        brandLists.add("Dr.Martens");
        brandLists.add("Dsquared2");
        brandLists.add("Fendi");
        brandLists.add("Geox");
        brandLists.add("Givenchy");
        brandLists.add("Greg Lauren");
        brandLists.add("Gucci");
        brandLists.add("Guidi");
        brandLists.add("Hermès");
        brandLists.add("Jimmy Choo");
        brandLists.add("Kenzo");
        brandLists.add("Louis Vuitton");
        brandLists.add("Levi's");
        brandLists.add("Marc By Marc Jacobs");
        brandLists.add("MCM");
        brandLists.add("McQ Alexander McQueen");
        brandLists.add("Moschino");
        brandLists.add("Neil Barrett");
        brandLists.add("New Balance");
        brandLists.add("Nike");
        brandLists.add("Oakley");
        brandLists.add("Off-White");
        brandLists.add("Palm Angels");
        brandLists.add("Philipp Plein");
        brandLists.add("Prada");
        brandLists.add("Puma");
        brandLists.add("Raf Simons");
        brandLists.add("Rick Owen");
        brandLists.add("Supreme");
        brandLists.add("The North Face (TNF)");
        brandLists.add("Thom Browne");
        brandLists.add("Tom Ford");
        brandLists.add("Vans");
        brandLists.add("Venyx");
        brandLists.add("Versace");
        brandLists.add("Vogue");
        brandLists.add("Valentino");


        ArrayAdapter<String> brandAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, brandLists);

        // Drop down layout style - list view with radio button
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        brand.setAdapter(brandAdapter);



        Button button = view.findViewById(R.id.btnAdd);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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



                db.collection("CusProduct").add(products).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

            }
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
