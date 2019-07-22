package binh.pc.trigonic;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LoginFragment extends Fragment {
    private Button btnLogin;
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getActivity()
                    .getSharedPreferences(getString(R.string.login_shared_prefs), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(getString(R.string.login_shared_prefs), true);
            editor.putString(getString(R.string.name_shared_prefs), "Nguyễn Minh Tú");
            editor.putString(getString(R.string.phone_shared_prefs), "0899906998");
            editor.putString(getString(R.string.address_shared_prefs), "62 Tô Ký, phường Tân Hưng Thuận, Quận 12, Tp.HCM");
            editor.apply();
            getActivity().finish();
        });

        return view;
    }
}
