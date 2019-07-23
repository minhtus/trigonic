package binh.pc.trigonic.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.R;
import binh.pc.trigonic.database.AppDatabase;
import com.bumptech.glide.Glide;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context context;
    private List<Product> cart;

    public CartAdapter(Context context, List<Product> cart) {
        this.context = context;
        this.cart = cart;
    }

    public List<Product> getCart() {
        return cart;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        final Product cartItem = cart.get(position);
        holder.txtName.setText(cartItem.getName());
        holder.txtCond.setText(String.format("Tình trạng %.1f - Verify by Trigonic", cartItem.getCond()));
        holder.txtPrice.setText(String.format("₫%,d", cartItem.getPrice()));
        holder.imgClear.setOnClickListener(v -> {
            AppDatabase.getInstance(context).cartDAO().delete(cartItem);
            cart.remove(cartItem);
            this.notifyItemRemoved(position);
        });
        Glide.with(context)
                .load(cartItem.getImage())
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtCond;
        TextView txtPrice;
        ImageView image;
        ImageView imgClear;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtCond = itemView.findViewById(R.id.txtCond);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            image = itemView.findViewById(R.id.image);
            imgClear = itemView.findViewById(R.id.imgClear);
        }
    }
}
