package binh.pc.trigonic;

import android.content.Intent;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GuestSellFragment extends Fragment {
    private Button btnLogin;
    private Button btnRegister;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guest_sell, container, false);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnRegister = view.findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener((click) -> {
            Intent intent = new Intent(getActivity(), LoginRegisterActivity.class);
            intent.putExtra("FRAGMENT", 0);
            getActivity().startActivityForResult(intent, 1);
        });
        btnRegister.setOnClickListener((click) -> {
            Intent intent = new Intent(getActivity(), LoginRegisterActivity.class);
            intent.putExtra("FRAGMENT", 1);
            startActivity(intent);
        });
        return view;
    }

}
