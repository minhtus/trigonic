package binh.pc.trigonic;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.models.Product;
import binh.pc.trigonic.models.ProductAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenShoesFragment extends Fragment {
    private List<Product> productList;
    private ProductAdapter productAdapter;
    private RecyclerView productRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_men_shoes, container, false);
//        final Intent intent = new Intent(getActivity(), DetailProductActivity.class);
//        Button button = view.findViewById(R.id.imagebutton);
//        button.setOnClickListener(v -> startActivity(intent));

        fetchProducts();

        productRecyclerView = view.findViewById(R.id.recycler_men);
        productAdapter = new ProductAdapter(getContext(), productList);
        productRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        productRecyclerView.setAdapter(productAdapter);

        return view;
    }

    private void fetchProducts() {
        // TODO Input data for men here
        Product p1 = new Product(R.drawable.nam720s, "Nike Air max 720 SATRN", "Black/White", "Men", 7450000, 8);
        productList = new ArrayList<>(Arrays.asList(p1, p1, p1, p1, p1, p1));
    }

}
