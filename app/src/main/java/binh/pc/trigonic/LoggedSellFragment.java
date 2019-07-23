package binh.pc.trigonic;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;

import java.util.ArrayList;

public class LoggedSellFragment extends Fragment {
    private RecyclerView imageRecyclerView;
    private ImageButton btnAddPhotos;


    public LoggedSellFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logged_sell, container, false);
        btnAddPhotos = view.findViewById(R.id.btnAddPhotos);
        btnAddPhotos.setOnClickListener(v -> {
            ImagePicker.create(this)
                    .limit(6)
                    .toolbarImageTitle(getString(R.string.image_picker_toolbar_title))
                    .start();
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            ArrayList<Image> pickedImages = (ArrayList<Image>) ImagePicker.getImages(data);
            Intent intent = new Intent(getActivity(), SubmitProductActivity.class);
            intent.putExtra("IMAGES", pickedImages);
            startActivity(intent);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
