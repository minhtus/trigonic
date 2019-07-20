package binh.pc.trigonic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.models.ImageAdapter;
import com.esafirm.imagepicker.model.Image;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.*;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class SubmitProductFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    private EditText edtName;
    private EditText edtCondition;
    private EditText edtSize;
    private EditText edtPrice;
    private Button btnAddPhotos;

    private RecyclerView imageRecyclerView;
    private ImageAdapter imageAdapter;

    public SubmitProductFragment() {
        // Required empty public constructor
    }

    private static final String IMAGES_PARAM = "images";

    public static SubmitProductFragment newInstance(ArrayList<Image> images) {
        SubmitProductFragment fragment = new SubmitProductFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(IMAGES_PARAM, images);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_submit_product, container, false);

        imageRecyclerView = view.findViewById(R.id.recycler_images);
        imageRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        Bundle bundle = this.getArguments();
        List<Image> imageList = bundle.getParcelableArrayList(IMAGES_PARAM);
        imageAdapter = new ImageAdapter(getContext(), imageList);
        imageRecyclerView.setAdapter(imageAdapter);
        edtName = view.findViewById(R.id.edtName);
        edtCondition = view.findViewById(R.id.edtCondition);
        edtSize = view.findViewById(R.id.edtSize);
        edtPrice = view.findViewById(R.id.edtPrice);

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
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brand.setAdapter(brandAdapter);

        Button button = view.findViewById(R.id.btnAdd);
        button.setOnClickListener(v -> {
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
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
