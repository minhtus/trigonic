package binh.pc.trigonic;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    Fragment fragment = null;
    private int[] carouselImages = {R.drawable.capture};
    private CarouselView carouselView;

    private ImageListener imageListener = (position, imageView) -> imageView.setImageResource(carouselImages[position]);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        carouselView =  findViewById(R.id.carouselView);
        carouselView.setPageCount(carouselImages.length);
        carouselView.setImageListener(imageListener);

        loadFragment(new LoginFragment());
//        btnLogin = findViewById(R.id.btnLogin);
//        btnLogin.setOnClickListener(v -> {
//            SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.login_shared_prefs), Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putBoolean(getString(R.string.login_shared_prefs), true);
//            editor.apply();
//            this.finish();
//        });
        TabLayout tabLayout = findViewById(R.id.mid_navigation2);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new LoginFragment();
                        break;
                    case 1:
                        fragment = new RegisterFragment();
                        break;
                }
                loadFragment(fragment);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_product_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}
