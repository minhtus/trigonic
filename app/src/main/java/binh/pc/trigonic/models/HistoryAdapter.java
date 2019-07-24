package binh.pc.trigonic.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import binh.pc.trigonic.database.AppDatabase;
import com.bumptech.glide.Glide;

import java.util.List;

import binh.pc.trigonic.R;
import com.google.android.material.button.MaterialButton;

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
        holder.txtStatus.setText(historyItem.getStatus());
        holder.txtName.setText(historyItem.getBranch() +" "+ historyItem.getName());
        holder.txtCond.setText(String.format("Tình trạng %.1f - Size %.0f", historyItem.getCond(),historyItem.getSize()));
        holder.txtPrice.setText(String.format("Giá đăng ₫%,d", historyItem.getPrice()));
        holder.txtFee.setText(String.format("Chi phí dịch vụ: %s", historyItem.getFee()));
        Bitmap bmImg = BitmapFactory.decodeFile(historyItem.getImage());
        holder.image.setImageBitmap(bmImg);

        if (ProductHistory.PENDING.equals(historyItem.getStatus())) {
            MaterialButton btnCancel = new MaterialButton(context);
            btnCancel.setText("Huỷ mặt hàng");
            btnCancel.setOnClickListener(v -> {
                historyItem.setStatus(ProductHistory.CANCELED);
                AppDatabase.getInstance(context).historyProductDAO().update(historyItem);
                Toast.makeText(context, "Huỷ mặt hàng thành công", Toast.LENGTH_LONG).show();
            });
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            params.addRule(RelativeLayout.ALIGN_PARENT_END);
            params.addRule(RelativeLayout.BELOW, R.id.layout_info);
            btnCancel.setLayoutParams(params);
            holder.layout.addView(btnCancel);
        }
    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView txtStatus;
        TextView txtName;
        TextView txtCond;
        TextView txtPrice;
        TextView txtFee;
        ImageView image;
        RelativeLayout layout;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtStatus = itemView.findViewById(R.id.txtStatus);
            txtName = itemView.findViewById(R.id.txtName);
            txtCond = itemView.findViewById(R.id.txtCond);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtFee = itemView.findViewById(R.id.txtFee);
            image = itemView.findViewById(R.id.image);
            layout = itemView.findViewById(R.id.layout_product_history);
        }
    }
}
