package binh.pc.trigonic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.models.Product;
import binh.pc.trigonic.models.ProductAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static androidx.core.content.ContextCompat.getSystemService;

public class SearchActivity extends Fragment {
    MaterialSearchView searchView;
    Toolbar toolbar;
    private List<Product> productList;
    private ProductAdapter productAdapter;
    private RecyclerView productRecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_search, container, false);
        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        searchView = view.findViewById(R.id.search_view);
        searchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        searchView.setEllipsize(true);
        searchView.showSearch(false);
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getActivity().getApplicationContext(),query,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {

            }
        });

        setHasOptionsMenu(true);
        fetchProducts();

        productRecyclerView = view.findViewById(R.id.recycler_men);
        productAdapter = new ProductAdapter(getContext(), productList);
        productRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        productRecyclerView.setAdapter(productAdapter);

        return view;
    }

    private void fetchProducts() {
        // TODO Input data for men here
        Product p4 = new Product(R.drawable.nam720s, "Nike Air max 720 SATRN", "Đen/Trắng", "Nam", 7450000,7.5,"Nike", 9);
        Product p2 = new Product(R.drawable.namiv, "Nike Air Monarch IV", "Đen/Trắng", "Nam", 7450000,8,"Nike", 8);
        Product p3 = new Product(R.drawable.nabm, "Nike Air Barrage Mid", "Đen/Trắng", "Nam", 7450000,7,"Nike", 8.6);
        Product p9 = new Product(R.drawable.nam270r, "Nike Air Max 270 React", "Đen/Trắng", "Nam", 7450000,8,"Nike", 8);
        Product p5 = new Product(R.drawable.nre55p, "Nike React Element 55 Preminum", "Đen/Trắng", "Nam", 7450000,7,"Nike", 7);
        Product p6 = new Product(R.drawable.pg3, "Nike SF Air Force Hi", "Đen/Trắng", "Nam", 7450000,8,"Nike", 8);
        Product p7 = new Product(R.drawable.aj14rse, "Air Jordan 14 Retro SE", "Đen/Trắng", "Nam", 7450000,8,"Jordan", 9);
        Product p8 = new Product(R.drawable.ajxxxii, "Air Jordan XXXIII", "Đen/Trắng", "Nam", 7450000,7.5,"Jordan", 8);
        Product p1 = new Product(R.drawable.jpm720, "Jordan Proto-Max 720", "Đen/Trắng", "Nam", 7450000,8,"Jordan", 9);
        Product p10 = new Product(R.drawable.juf3l, "Jordan Ultra Fly 3 Low", "Đen/Trắng", "Nam", 7450000,9,"Jordan", 8);
        Product p11 = new Product(R.drawable.aj1rls, "Air Jordan 1 Retro Low Slip", "Đen/Trắng", "Nữ", 8500000,7.5,"Jordan", 9);
        Product p12 = new Product(R.drawable.aj1rhp, "Air Jordan 1 Retro High Premium", "Đen/Trắng", "Nữ", 8500000,9.5,"Jordan", 8.7);
        Product p13 = new Product(R.drawable.nm2ktse, "Nike M2k Tenko SE", "Đen/Trắng", "Nữ", 8500000,8,"Nike", 8.6);
        Product p14 = new Product(R.drawable.nre55, "Nike React Element 55", "Đen/Trắng", "Nữ", 8500000,8.5,"Nike", 9);
        Product p15 = new Product(R.drawable.ncracp, "NikeCourt Royale AC", "Đen/Trắng", "Nữ", 8500000,7,"Nike", 8);
        Product p16 = new Product(R.drawable.namff720, "Nike Air Max FF 720", "Đen/Trắng", "Nữ", 8500000,7.5,"Nike", 9);
        Product p17 = new Product(R.drawable.nam90, "Nike Air Max 90", "Đen/Trắng", "Nữ", 8500000,7.5,"Nike", 9);
        Product p18 = new Product(R.drawable.nbmby, "Nike Blazer Mid By You", "Đen/Trắng", "Nữ", 8500000,7.5,"Nike", 9);
        Product p19 = new Product(R.drawable.nam270, "Nike Air Max 270", "Đen/Trắng", "Nữ", 8500000,7.5,"Nike", 9);
        Product p20 = new Product(R.drawable.ncclxf, "Air Jordan 1 Retro Low Slip", "Đen/Trắng", "Nữ", 8500000,7.5,"Jordan", 9);
        productList = new ArrayList<>(Arrays.asList(p1, p12, p3, p4, p15, p6, p17, p8, p19, p10,p2,p11,p13,p5,p16,p7,p18,p9,p20,p14));
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.material_search, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    @Override
    public void onBackPressed(){
        if (searchView.isSearchOpen()){
            searchView.closeSearch();
        }else {
            getActivity().onBackPressed();
        }
    }
}
