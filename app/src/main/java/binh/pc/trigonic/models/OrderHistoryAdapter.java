package binh.pc.trigonic.models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.OrderDetailActivity;
import binh.pc.trigonic.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.OrderPendingViewHolder> {
    private Context context;
    private List<Order> orderList;

    public OrderHistoryAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderPendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_history_item, parent, false);
        return new OrderPendingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderPendingViewHolder holder, int position) {
        final Order order = orderList.get(position);
        final Product firstProduct = order.getProducts().get(0);
        holder.txtStatus.setText(order.getStatus());
        holder.txtName.setText(firstProduct.getName());
        if (order.getProducts().size() > 1) {
            holder.txtMore.setText(String.format("và %s sản phẩm khác", order.getProducts().size() -1));
        }
        holder.txtTotal.setText(String.format("₫%,d", order.getTotal()));
        Glide.with(context).load(firstProduct.getImage())
                .into(holder.image);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, OrderDetailActivity.class);
            intent.putExtra("ORDER", order);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class OrderPendingViewHolder extends RecyclerView.ViewHolder {
        TextView txtStatus;
        ImageView image;
        TextView txtName;
        TextView txtMore;
        TextView txtTotal;

        public OrderPendingViewHolder(@NonNull View itemView) {
            super(itemView);
            txtStatus = itemView.findViewById(R.id.txtStatus);
            image = itemView.findViewById(R.id.image);
            txtName = itemView.findViewById(R.id.txtName);
            txtMore = itemView.findViewById(R.id.txtMore);
            txtTotal = itemView.findViewById(R.id.txtTotal);
        }
    }
}
