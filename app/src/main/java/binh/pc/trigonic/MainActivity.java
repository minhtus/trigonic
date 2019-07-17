package binh.pc.trigonic;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());
        BottomNavigationView bottomNavigationView =  findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.action_home:
                    fragment = new HomeFragment();
                    break;
                case R.id.action_sell:
                    SharedPreferences sharedPreferences =
                            getSharedPreferences(getString(R.string.login_shared_prefs), Context.MODE_PRIVATE);
                    boolean logged = sharedPreferences.getBoolean(getString(R.string.login_shared_prefs), false);
                    fragment = logged ? new LoggedSellFragment() : new GuestSellFragment();
                    break;
                case R.id.action_cart:
                    fragment = new CartFragment();
                    break;
                case R.id.action_account:
                    fragment = new ProfileFragment();
                    break;
            }
            return loadFragment(fragment);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                SharedPreferences sharedPreferences =
                        getSharedPreferences(getString(R.string.login_shared_prefs), Context.MODE_PRIVATE);
                boolean logged = sharedPreferences.getBoolean(getString(R.string.login_shared_prefs), false);
                fragment = logged ? new LoggedSellFragment() : new GuestSellFragment();
                loadFragment(fragment);
        }
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}

