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
        // Required empty public constructor
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
        Product p1 = new Product(R.drawable.jpm720, "Jordan Proto-Max 720", "Black/Red", "Men", 8500000, 8);
        Product p2 = new Product(R.drawable.nre55, "Nike React Element 55", "White/Yellow", "Men", 7800000, 8);
        Product p3 = new Product(R.drawable.ncracp, "Nike Court Royal Acp", "White/Blue", "Men", 7600000, 8.5);
        Product p4 = new Product(R.drawable.ncclxf, "Nike Classic Cortez xf", "White/Red", "Men", 9200000, 9.5);
        Product p5 = new Product(R.drawable.aj14rse, "Air jordan 14", "Yellow", "Men", 9520000, 9.5);
        Product p6 = new Product(R.drawable.ajxxxii, "Air jordan XXXII", "Black/Red", "Men", 9850000, 9.5);
        Product p7 = new Product(R.drawable.aj1rls, "Air jordan 1 low slip", "White/Red", "Men", 9000000, 8);
        Product p8 = new Product(R.drawable.aj1rhp, "Air jordan Travis Scott", "Blue/Red", "Men", 9200000, 8.5);
        Product p9 = new Product(R.drawable.namff720, "Nike Air max FF 720", "Black", "Men", 7600000, 8.5);
        Product p10 = new Product(R.drawable.nam90, "Nike Air max 90", "Black/White", "Men", 8500000, 9.5);
        Product p11 = new Product(R.drawable.nam270, "Nike Air max 270", "White", "Men", 7860000, 8);
        Product p12 = new Product(R.drawable.nam270r, "Nike Air max 270 React", "Black/White", "Men", 7590000, 7.5);
        Product p13 = new Product(R.drawable.namiv, "Nike Air max Tailwind", "Black/White", "Men", 8940000, 9);
        Product p14 = new Product(R.drawable.nabm, "Nike Air max BM", "Black/White", "Men", 9580000, 8.5);
        outstandingList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
        airJordanList = new ArrayList<>(Arrays.asList(p5, p6, p7, p8));
        nikeAirList = new ArrayList<>(Arrays.asList(p9, p10, p11, p12, p13, p14));
    }

}
