package binh.pc.trigonic;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.database.AppDatabase;
import binh.pc.trigonic.models.Order;
import binh.pc.trigonic.models.OrderHistoryAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderPendingFragment extends Fragment {
    OrderHistoryAdapter orderHistoryAdapter;
    RecyclerView orderPendingRecyclerView;

    public OrderPendingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_pending, container, false);
        orderHistoryAdapter = new OrderHistoryAdapter(getContext(), AppDatabase.getInstance(getContext()).orderDAO().getByStatus(Order.PENDING));
        orderPendingRecyclerView = view.findViewById(R.id.recycler_pending_order);
        orderPendingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        orderPendingRecyclerView.setAdapter(orderHistoryAdapter);
        return view;
    }

}
