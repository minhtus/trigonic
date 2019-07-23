package binh.pc.trigonic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class GuestSellActivity extends AppCompatActivity {
    private Button btnLogin;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_sell);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener((click) -> {
            Intent intent = new Intent(this, LoginRegisterActivity.class);
            intent.putExtra("FRAGMENT", 0);
            startActivityForResult(intent, 1);
        });
        btnRegister.setOnClickListener((click) -> {
            Intent intent = new Intent(this, LoginRegisterActivity.class);
            intent.putExtra("FRAGMENT", 1);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            finish();
            Intent intent= new Intent(this,LoggedSellActivity.class);
            startActivity(intent);
        }
    }
}
