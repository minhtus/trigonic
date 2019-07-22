package binh.pc.trigonic;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.textfield.TextInputEditText;

public class OrderActivity extends AppCompatActivity {
    TextInputEditText edtPhone;
    TextInputEditText edtName;
    TextInputEditText edtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> this.finish());

        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtAddress = findViewById(R.id.edtAddress);

        SharedPreferences sharedPreferences =
                getSharedPreferences(getString(R.string.login_shared_prefs), Context.MODE_PRIVATE);
        edtName.setText(sharedPreferences.getString(getString(R.string.name_shared_prefs), ""));
        edtPhone.setText(sharedPreferences.getString(getString(R.string.phone_shared_prefs), ""));
        edtAddress.setText(sharedPreferences.getString(getString(R.string.address_shared_prefs), ""));

    }
}
