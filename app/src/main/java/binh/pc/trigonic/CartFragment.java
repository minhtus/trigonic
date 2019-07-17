package binh.pc.trigonic;

import android.os.Build;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import binh.pc.trigonic.database.AppDatabase;
import binh.pc.trigonic.models.Product;

import java.util.List;

public class CartFragment extends Fragment{
    private List<Product> productList;
    private ImageView imgClear;
    TextView txtTotal;

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView( LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = layoutInflater.inflate(R.layout.fragment_cart, viewGroup, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        productList = AppDatabase.getInstance(getContext()).productDAO().getAll();
        imgClear = view.findViewById(R.id.imgClear);
        imgClear.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Clear clicked", Toast.LENGTH_SHORT).show();
        });
        txtTotal = view.findViewById(R.id.txtTotal);
        txtTotal.setText(String.format("₫%,d", productList.stream()
                .map(product -> product.getPrice())
                .reduce(0, Integer::sum)));

        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.topbar, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getContext(), "selected", Toast.LENGTH_SHORT).show();
        return true;
    }

}
