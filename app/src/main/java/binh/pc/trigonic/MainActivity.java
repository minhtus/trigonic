package binh.pc.trigonic;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;


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
                    fragment = new GuestSellFragment();
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

