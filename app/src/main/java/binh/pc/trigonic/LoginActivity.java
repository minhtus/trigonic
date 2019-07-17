package binh.pc.trigonic;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;

public class LoginActivity extends Activity {
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.login_shared_prefs), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(getString(R.string.login_shared_prefs), true);
            editor.apply();
            this.finish();
        });
    }

}
