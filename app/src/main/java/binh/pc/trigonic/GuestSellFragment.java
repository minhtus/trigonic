package binh.pc.trigonic;

import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

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
            Toast.makeText(getContext(), "Login clicked", Toast.LENGTH_SHORT).show();
        });
        btnRegister.setOnClickListener((click) -> {
            Toast.makeText(getContext(), "Register clicked", Toast.LENGTH_SHORT).show();
        });
        return view;
    }

}
