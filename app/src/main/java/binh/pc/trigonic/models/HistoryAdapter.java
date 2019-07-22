package binh.pc.trigonic.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import binh.pc.trigonic.R;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private Context context;
    private List<ProductHistory> history;

    public HistoryAdapter(Context context, List<ProductHistory> history) {
        this.context = context;
        this.history = history;
    }

    public List<ProductHistory> getHistory() {
        return history;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new HistoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        final ProductHistory historyItem = history.get(position);
        holder.txtName.setText(historyItem.getBranch() +" "+ historyItem.getName() +" (đang check)");
        holder.txtCond.setText(String.format("Tình trạng %.1f - Size %.0f", historyItem.getCond(),historyItem.getSize()));
        holder.txtPrice.setText(String.format("₫%,d", historyItem.getPrice()));
        Bitmap bmImg = BitmapFactory.decodeFile(historyItem.getImage());
        holder.image.setImageBitmap(bmImg);

    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtCond;
        TextView txtPrice;
        ImageView image;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtCond = itemView.findViewById(R.id.txtCond);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            image = itemView.findViewById(R.id.image);
        }
    }
}
