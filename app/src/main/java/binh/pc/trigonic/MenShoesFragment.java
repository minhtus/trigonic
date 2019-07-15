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

        fetchProducts();

        productRecyclerView = view.findViewById(R.id.recycler_men);
        productAdapter = new ProductAdapter(getContext(), productList);
        productRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        productRecyclerView.setAdapter(productAdapter);

        return view;
    }

    private void fetchProducts() {
        // TODO Input data for men here
        Product p4 = new Product(R.drawable.nam720s, "Nike Air max 720 SATRN", "Black/White", "Men", 7450000, 8);
        Product p2 = new Product(R.drawable.namiv, "Nike Air Monarch IV", "Black/White", "Men", 7450000, 8);
        Product p3 = new Product(R.drawable.nabm, "Nike Air Barrage Mid", "Black/White", "Men", 7450000, 8);
        Product p9 = new Product(R.drawable.nam270r, "Nike Air Max 270 React", "Black/White", "Men", 7450000, 8);
        Product p5 = new Product(R.drawable.nre55p, "Nike React Element 55 Preminum", "Black/White", "Men", 7450000, 8);
        Product p6 = new Product(R.drawable.pg3, "Nike SF Air Force Hi", "Black/White", "Men", 7450000, 8);
        Product p7 = new Product(R.drawable.aj14rse, "Air Jordan 14 Retro SE", "Black/White", "Men", 7450000, 8);
        Product p8 = new Product(R.drawable.ajxxxii, "Air Jordan XXXIII", "Black/White", "Men", 7450000, 8);
        Product p1 = new Product(R.drawable.jpm720, "Jordan Proto-Max 720", "Black/White", "Men", 7450000, 8);
        Product p10 = new Product(R.drawable.juf3l, "Jordan Ultra Fly 3 Low", "Black/White", "Men", 7450000, 8);
        productList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
    }

}
