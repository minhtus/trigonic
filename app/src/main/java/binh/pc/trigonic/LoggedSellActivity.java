package binh.pc.trigonic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;

import java.util.ArrayList;

import binh.pc.trigonic.database.AppDatabase;
import binh.pc.trigonic.models.CartAdapter;
import binh.pc.trigonic.models.HistoryAdapter;

public class LoggedSellActivity extends AppCompatActivity {
    private RecyclerView historyRecyclerView;
    private HistoryAdapter cartAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_sell);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> this.finish());
        cartAdapter = new HistoryAdapter(this, AppDatabase.getInstance(this).historyProductDAO().getAll());
        historyRecyclerView = findViewById(R.id.recycler_history);
        historyRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        historyRecyclerView.setAdapter(cartAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ImagePicker.create(this)
                .limit(6)
                .toolbarImageTitle(getString(R.string.image_picker_toolbar_title))
                .start();
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            ArrayList<Image> pickedImages = (ArrayList<Image>) ImagePicker.getImages(data);
            Intent intent = new Intent(this, SubmitProductActivity.class);
            intent.putExtra("IMAGES", pickedImages);
            startActivityForResult(intent,1);
        }
        if (requestCode == 1){
            finish();
            startActivity(getIntent());
        }
    }
}
