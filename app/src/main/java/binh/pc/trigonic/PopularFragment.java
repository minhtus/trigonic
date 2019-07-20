package binh.pc.trigonic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.models.Product;
import binh.pc.trigonic.models.ProductAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopularFragment extends Fragment {
    private List<Product> outstandingList;
    private List<Product> airJordanList;
    private List<Product> nikeAirList;
    private ProductAdapter outstandingAdapter;
    private ProductAdapter airJordanAdapter;
    private ProductAdapter nikeAirAdapter;
    private RecyclerView outStandingRecyclerView;
    private RecyclerView airJordanRecyclerView;
    private RecyclerView nikeAirRecyclerView;

    public PopularFragment() {
        // RequiĐỏ empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);

        fetchProducts();

        outStandingRecyclerView = view.findViewById(R.id.recycler_outstanding);
        outstandingAdapter = new ProductAdapter(getContext(), outstandingList);
        outStandingRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
        outStandingRecyclerView.setAdapter(outstandingAdapter);

        airJordanRecyclerView = view.findViewById(R.id.recycler_airJordan);
        airJordanAdapter = new ProductAdapter(getContext(), airJordanList);
        airJordanRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
        airJordanRecyclerView.setAdapter(airJordanAdapter);

        nikeAirRecyclerView = view.findViewById(R.id.recycler_nikeAir);
        nikeAirAdapter = new ProductAdapter(getContext(), nikeAirList);
        nikeAirRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
        nikeAirRecyclerView.setAdapter(nikeAirAdapter);

        return view;
    }

    private void fetchProducts() {
        // TODO Data input for popular tab is here
        Product p1 = new Product(R.drawable.jpm720, "Jordan Proto-Max 720", "Đen/Đỏ", "Nam", 8500000, 42, "Nike", 8);
        Product p2 = new Product(R.drawable.nre55, "Nike React Element 55", "Trắng/Vàng", "Nam", 7800000, 41.5, "Nike", 8);
        Product p3 = new Product(R.drawable.ncracp, "Nike Court Royal Acp", "Trắng/Xanh", "Nam", 7600000, 42, "Nike", 8.5);
        Product p4 = new Product(R.drawable.ncclxf, "Nike Classic Cortez xf", "Trắng/Đỏ", "Nam", 9200000, 40, "Nike", 9.5);
        Product p5 = new Product(R.drawable.aj14rse, "Air jordan 14", "Vàng", "Nam", 9520000, 42, "Nike",9.5);
        Product p6 = new Product(R.drawable.ajxxxii, "Air jordan XXXII", "Đen/Đỏ", "Nam", 9850000, 42, "Nike",9.5);
        Product p7 = new Product(R.drawable.aj1rls, "Air jordan 1 low slip", "Trắng/Đỏ", "Nam", 9000000, 40, "Nike",8);
        Product p8 = new Product(R.drawable.aj1rhp, "Air jordan Travis Scott", "Xanh/Đỏ", "Nam", 9200000, 41, "Nike",8.5);
        Product p9 = new Product(R.drawable.namff720, "Nike Air max FF 720", "Đen", "Nam", 7600000, 43.2, "Nike",8.5);
        Product p10 = new Product(R.drawable.nam90, "Nike Air max 90", "Đen/Trắng", "Nam", 8500000, 44, "Nike",9.5);
        Product p11 = new Product(R.drawable.nam270, "Nike Air max 270", "Trắng", "Nam", 7860000, 41.7, "Nike",8);
        Product p12 = new Product(R.drawable.nam270r, "Nike Air max 270 React", "Đen/Trắng", "Nam", 7590000, 42.3, "Nike",7.5);
        Product p13 = new Product(R.drawable.namiv, "Nike Air max Tailwind", "Đen/Trắng", "Nam", 8940000, 41, "Nike",9);
        Product p14 = new Product(R.drawable.nabm, "Nike Air max BM", "Đen/Trắng", "Nam", 9580000, 39, "Nike",8.5);
        outstandingList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
        airJordanList = new ArrayList<>(Arrays.asList(p5, p6, p7, p8));
        nikeAirList = new ArrayList<>(Arrays.asList(p9, p10, p11, p12, p13, p14));
    }

}
