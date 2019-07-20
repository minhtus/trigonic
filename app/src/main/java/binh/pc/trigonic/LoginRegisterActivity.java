package binh.pc.trigonic;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class LoginRegisterActivity extends AppCompatActivity {
    Fragment fragment = null;
    private int[] carouselImages = {R.drawable.capture};
    private CarouselView carouselView;

    private ImageListener imageListener = (position, imageView) -> imageView.setImageResource(carouselImages[position]);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(carouselImages.length);
        carouselView.setImageListener(imageListener);

        Intent intent = this.getIntent();
        TabLayout tabLayout = findViewById(R.id.mid_navigation2);
        switch (intent.getIntExtra("FRAGMENT", 0)) {
            case 0:
                loadFragment(new LoginFragment());
                break;
            case 1:
                loadFragment(new RegisterFragment());
                tabLayout.selectTab(tabLayout.getTabAt(1));
                break;
        }
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

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.login_register_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}
