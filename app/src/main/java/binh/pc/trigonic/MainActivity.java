package binh.pc.trigonic;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadFragment(new HomeFragment());
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.action_add:
                        fragment = new AddProductFragment();
                        break;
                    case R.id.action_cart:
                        fragment = new ShoppingCartFragment();
                        break;
                    case R.id.action_account:
                        fragment = new LoginActivity();
                        break;
                }
                return LoadFragment(fragment);
            }
        });

//        BottomNavigationView midNavigationView = (BottomNavigationView) findViewById(R.id.mid_navigation);
//        midNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()){
//                    case R.id.action_popular:
//                        fragment = new HomeFragment();
//                        break;
//                    case R.id.action_men:
//                        fragment = new MenShoesFragment();
//                        break;
//                    case R.id.action_women:
//                        fragment = new WomenShoesFragment();
//                        break;
//                }
//                return LoadFragment(fragment);
//            }
//        });

    }

    private boolean LoadFragment(Fragment fragment){
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

