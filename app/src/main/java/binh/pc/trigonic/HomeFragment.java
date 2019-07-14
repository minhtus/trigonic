package binh.pc.trigonic;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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

        BottomNavigationView midNavigationView =  view.findViewById(R.id.mid_navigation);
        midNavigationView.setOnNavigationItemSelectedListener(menuItem -> {

            switch (menuItem.getItemId()){
                case R.id.action_popular:
//                        SpannableString san = new SpannableString(menuItem.getTitle());
//                        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
//                        san.setSpan(bss, 0, san.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//                        san.setSpan(new RelativeSizeSpan(.7f),0,san.length(),0);
//                        menuItem.setTitle(san);
//                        fragment = new HomeFragment();
                    fragment = new PopularFragment();
                    break;
                case R.id.action_men:
//                        SpannableString san1 = new SpannableString(menuItem.getTitle());
//                        final StyleSpan bss1 = new StyleSpan(android.graphics.Typeface.BOLD);
//                        san1.setSpan(bss1, 0, san1.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//                        san1.setSpan(new RelativeSizeSpan(.7f),0,san1.length(),0);
//                        menuItem.setTitle(san1);
                    fragment = new MenShoesFragment();
                    break;
                case R.id.action_women:
//                        SpannableString san2 = new SpannableString(menuItem.getTitle());
//                        final StyleSpan bss2 = new StyleSpan(android.graphics.Typeface.BOLD);
//                        san2.setSpan(bss2, 0, san2.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//                        san2.setSpan(new RelativeSizeSpan(.7f),0,san2.length(),0);
//                        menuItem.setTitle(san2);
                    fragment = new WomenShoesFragment();
                    break;
            }
            return loadFragment(fragment);
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
