package binh.pc.trigonic;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import binh.pc.trigonic.database.AppDatabase;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());
        bottomNavigationView =  findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.action_home:
                    fragment = new HomeFragment();
                    break;
                case R.id.action_search:
                    fragment = new SearchActivity();
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
    protected void onResume() {
        super.onResume();
        int cartSize = AppDatabase.getInstance(this).cartDAO().getAll().size();
        int menuItemId = bottomNavigationView.getMenu().getItem(2).getItemId();
        BadgeDrawable badge = bottomNavigationView.getOrCreateBadge(menuItemId);
        if (cartSize > 0) {
            badge.setVisible(true);
            badge.setNumber(cartSize);
        } else {
            badge.clearNumber();
            badge.setVisible(false);
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

