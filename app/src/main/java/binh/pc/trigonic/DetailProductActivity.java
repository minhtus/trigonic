package binh.pc.trigonic;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class DetailProductActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        if("LOGIN/REGISTER".equals(item)){
            Intent intent = new Intent(this, ProfileFragment.class);
            startActivity(intent);
        }
        if("ADD PRODUCT".equals(item)){
            Intent intent = new Intent(this, GuestSellFragment.class);
            startActivity(intent);
        }
        if("MEN".equals(item)){
            Intent intent = new Intent(this, MenShoesFragment.class);
            startActivity(intent);
        }
        if("WOMEN".equals(item)){
            Intent intent = new Intent(this, WomenShoesFragment.class);
            startActivity(intent);
        }
        if("HOME".equals(item)){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void clickToViewCart(View view) {
        Intent intent = new Intent(this, CartFragment.class);
        startActivity(intent);
    }
}
