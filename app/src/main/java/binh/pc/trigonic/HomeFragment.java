package binh.pc.trigonic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

public class HomeFragment extends Fragment {
    Fragment fragment = null;
    private int[] carouselImages = {R.drawable.capture, R.drawable.image, R.drawable.img4};
    private CarouselView carouselView;

    ImageListener imageListener = (position, imageView) -> imageView.setImageResource(carouselImages[position]);
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        carouselView =  view.findViewById(R.id.carouselView);
        carouselView.setPageCount(carouselImages.length);
        carouselView.setImageListener(imageListener);
        carouselView.setImageClickListener(position ->
                Toast.makeText(getActivity() , "Clicked item: "+ position, Toast.LENGTH_SHORT).show());

        fragment = new PopularFragment();
        loadFragment(fragment);

        TabLayout tabLayout = view.findViewById(R.id.mid_navigation);
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            fragment = new PopularFragment();
                            break;
                        case 1:
                            fragment = new MenShoesFragment();
                            break;
                        case 2:
                            fragment = new WomenShoesFragment();
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

        return view;
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_product_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
            return true;
        }
        return false;
    }
}
