package binh.pc.trigonic;

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

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.models.Product;
import binh.pc.trigonic.models.ProductAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WomenShoesFragment extends Fragment {
    private List<Product> productList;
    private ProductAdapter productAdapter;
    private RecyclerView productRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_women_shoes, container, false);

        fetchProducts();

        productRecyclerView = view.findViewById(R.id.recycler_women);
        productAdapter = new ProductAdapter(getContext(), productList);
        productRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        productRecyclerView.setAdapter(productAdapter);

        return view;
    }

    private void fetchProducts() {
        // TODO input data for women here
        Product p1 = new Product(R.drawable.aj1rls, "Air Jordan 1 Retro Low Slip", "Đen/Trắng", "Nữ", 8500000,7.5,"Jordan", 9);
        Product p2 = new Product(R.drawable.aj1rhp, "Air Jordan 1 Retro High Premium", "Đen/Trắng", "Nữ", 8500000,9.5,"Jordan", 8.7);
        Product p3 = new Product(R.drawable.nm2ktse, "Nike M2k Tenko SE", "Đen/Trắng", "Nữ", 8500000,8,"Nike", 8.6);
        Product p4 = new Product(R.drawable.nre55, "Nike React Element 55", "Đen/Trắng", "Nữ", 8500000,8.5,"Nike", 9);
        Product p5 = new Product(R.drawable.ncracp, "NikeCourt Royale AC", "Đen/Trắng", "Nữ", 8500000,7,"Nike", 8);
        Product p6 = new Product(R.drawable.namff720, "Nike Air Max FF 720", "Đen/Trắng", "Nữ", 8500000,7.5,"Nike", 9);
        Product p7 = new Product(R.drawable.nam90, "Nike Air Max 90", "Đen/Trắng", "Nữ", 8500000,7.5,"Nike", 9);
        Product p8 = new Product(R.drawable.nbmby, "Nike Blazer Mid By You", "Đen/Trắng", "Nữ", 8500000,7.5,"Nike", 9);
        Product p9 = new Product(R.drawable.nam270, "Nike Air Max 270", "Đen/Trắng", "Nữ", 8500000,7.5,"Nike", 9);
        Product p10 = new Product(R.drawable.ncclxf, "Air Jordan 1 Retro Low Slip", "Đen/Trắng", "Nữ", 8500000,7.5,"Jordan", 9);
        productList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
    }

}
