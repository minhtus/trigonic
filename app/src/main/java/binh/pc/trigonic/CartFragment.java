package binh.pc.trigonic;

import android.os.Build;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.database.AppDatabase;
import binh.pc.trigonic.models.CartAdapter;
import binh.pc.trigonic.models.Product;

import java.util.List;

public class CartFragment extends Fragment{
    TextView txtTotal;
    private CartAdapter cartAdapter;
    private RecyclerView cartRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        cartAdapter = new CartAdapter(getContext(), AppDatabase.getInstance(getContext()).productDAO().getAll());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView( LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = layoutInflater.inflate(R.layout.fragment_cart, viewGroup, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        cartRecyclerView = view.findViewById(R.id.recycler_cart);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        cartRecyclerView.setAdapter(cartAdapter);

        txtTotal = view.findViewById(R.id.txtTotal);
        txtTotal.setText(String.format("₫%,d", cartAdapter.getCart().stream()
                .map(Product::getPrice)
                .reduce(0, Integer::sum)));
        Button btnProceedOrder= view.findViewById(R.id.btnProceedOrder);
        TextView text=view.findViewById(R.id.txtTotal);
        btnProceedOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Đặt hàng thành công", Toast.LENGTH_LONG).show();
                AppDatabase.getInstance(getContext()).productDAO().deleteAll();
                cartAdapter = new CartAdapter(getContext(), AppDatabase.getInstance(getContext()).productDAO().getAll());
                cartRecyclerView.setAdapter(cartAdapter);
                text.setText("đ0");
            }
        });
        return view;
    }
}
