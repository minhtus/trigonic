package binh.pc.trigonic;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    Fragment fragment = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, null);
        BottomNavigationView midNavigationView = (BottomNavigationView) view.findViewById(R.id.mid_navigation);
        midNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.action_popular:
                        SpannableString san = new SpannableString(menuItem.getTitle());
                        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
                        san.setSpan(bss, 0, san.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        san.setSpan(new RelativeSizeSpan(.7f),0,san.length(),0);
                        menuItem.setTitle(san);
                        fragment = new HomeFragment();
                        break;
                    case R.id.action_men:
                        SpannableString san1 = new SpannableString(menuItem.getTitle());
                        final StyleSpan bss1 = new StyleSpan(android.graphics.Typeface.BOLD);
                        san1.setSpan(bss1, 0, san1.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        san1.setSpan(new RelativeSizeSpan(.7f),0,san1.length(),0);
                        menuItem.setTitle(san1);
                        fragment = new MenShoesActivity();
                        break;
                    case R.id.action_women:
                        SpannableString san2 = new SpannableString(menuItem.getTitle());
                        final StyleSpan bss2 = new StyleSpan(android.graphics.Typeface.BOLD);
                        san2.setSpan(bss2, 0, san2.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        san2.setSpan(new RelativeSizeSpan(.7f),0,san2.length(),0);
                        menuItem.setTitle(san2);
                        fragment = new WomenShoesActivity();
                        break;
                }
                return LoadFragment(fragment);
            }
        });
        return view;
    }

    private boolean LoadFragment(Fragment fragment){
        if(fragment != null){
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
