package binh.pc.trigonic.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.OrderDetailViewHolder> {
    private Context context;
    private List<Product> productList;

    public OrderDetailAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public OrderDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_detail_item, parent, false);
        return new OrderDetailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailViewHolder holder, int position) {
        final Product product = productList.get(position);
        holder.txtName.setText(product.getName());
        holder.txtPrice.setText(String.format("₫%,d", product.getPrice()));
        Glide.with(context)
                .load(product.getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class OrderDetailViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtPrice;
        ImageView image;

        OrderDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            image = itemView.findViewById(R.id.image);
        }
    }
}
