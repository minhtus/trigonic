package binh.pc.trigonic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class ProfileFragment extends Fragment {
    private Button btnLogout;
    private TextView txtTitle1, txtTitle2;
    SharedPreferences sharedPreferences;
    MaterialCardView card ,cardSell;

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        card = view.findViewById(R.id.cardNavigate);

        sharedPreferences = getActivity().getSharedPreferences(getString(R.string.login_shared_prefs), Context.MODE_PRIVATE);
        boolean logged = sharedPreferences.getBoolean(getString(R.string.login_shared_prefs), false);

        btnLogout = view.findViewById(R.id.btnLogout);
        txtTitle1 = view.findViewById(R.id.txtTitle1);
        txtTitle2 = view.findViewById(R.id.txtTitle2);
        cardSell= view.findViewById(R.id.cardSell);

        if (logged) {
            txtTitle1.setText("Nguyễn Minh Tú");
            txtTitle1.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            txtTitle1.setTextSize(17);
            txtTitle2.setText("tu@gmail.com thành viên từ 28/09/2018");
            txtTitle2.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
            txtTitle2.setTextSize(15);
            btnLogout.setVisibility(View.VISIBLE);
            btnLogout.setOnClickListener(v -> {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(getString(R.string.login_shared_prefs), false);
                editor.apply();
                getActivity().finish();
                startActivity(getActivity().getIntent());
            });
            cardSell.setOnClickListener(v -> {
                Intent intent= new Intent(getContext(),LoggedSellActivity.class);
                startActivity(intent);
            });

        }
        if (!logged){
            card.setOnClickListener(v -> {
                Intent intent = new Intent(getContext(), LoginRegisterActivity.class);
                startActivityForResult(intent, 1);
            });
            cardSell.setOnClickListener(v -> {
                Intent intent= new Intent(getContext(),GuestSellActivity.class);
                startActivity(intent);
            });
        }

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                sharedPreferences = getActivity().getSharedPreferences(getString(R.string.login_shared_prefs), Context.MODE_PRIVATE);
                boolean logged = sharedPreferences.getBoolean(getString(R.string.login_shared_prefs), false);
                if (logged) {
                    txtTitle1.setText("Nguyễn Minh Tú");
                    txtTitle1.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                    txtTitle1.setTextSize(17);
                    txtTitle2.setText("tu@gmail.com thành viên từ 28/09/2018");
                    txtTitle2.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                    txtTitle2.setTextSize(15);
                    btnLogout.setVisibility(View.VISIBLE);
                    btnLogout.setOnClickListener(v -> {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(getString(R.string.login_shared_prefs), false);
                        editor.apply();
                        getActivity().finish();
                        startActivity(getActivity().getIntent());
                    });
                    card.setClickable(false);
                    cardSell.setOnClickListener(v -> {
                        Intent intent= new Intent(getContext(),LoggedSellActivity.class);
                        startActivity(intent);
                    });
                }
        }
    }
}
