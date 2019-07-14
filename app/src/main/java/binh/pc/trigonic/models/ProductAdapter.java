package binh.pc.trigonic.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import binh.pc.trigonic.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        final Product product = productList.get(position);
        holder.name.setText(product.getName());
        holder.color.setText(product.getColors());
        holder.category.setText(product.getCategory());
        holder.price.setText(String.format("₫%,d", product.getPrice()));
        holder.cond.setText(String.format("Cond %.1f", product.getCond()));
        Glide.with(context)
                .load(product.getImage())
                .into(holder.image);


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView color;
        TextView category;
        TextView price;
        TextView cond;

        ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.txtName);
            color = itemView.findViewById(R.id.txtColor);
            category = itemView.findViewById(R.id.txtCategory);
            price = itemView.findViewById(R.id.txtPrice);
            cond = itemView.findViewById(R.id.txtCond);
            image.setOnClickListener(v -> {
                Toast.makeText(v.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
