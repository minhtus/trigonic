package binh.pc.trigonic;

import android.app.DatePickerDialog;
import androidx.fragment.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener{
    private TextView txtBirthday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtBirthday = findViewById(R.id.txtBirthday);

        Spinner country = findViewById(R.id.country);
        country.setOnItemSelectedListener(this);
        List<String> countryLists = new ArrayList<>(Arrays.asList("Vietnam", "Afghanistan", "Albania", "American Samoa",
                "Andorra", "Angola", "Anguilla", "Australia", "Brazil", "Brunei Darussalam", "British Indian Ocean Territory",
                "Bulgaria", "Cambodia", "Canada", "China Mainland ", "Colombia", "Cuba", "Cyprus", "Czech Republic",
                "Ethiopia", "European Union", "France", "French Southern Territories", "Germany", "Grenada",
                "Hong Kong", "India", "Indonesia", "Italy", "Japan", "Republic of Korea", "Liberia", "Macau",
                "Mexico", "New Zealand", "Peru", "Philippines", "Qatar", "Singapore", "Taiwan", "United Kingdom",
                "United States", "Virgin Islands (British)", "Zimbabwe"));

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countryLists);

        // Drop down layout style - list view with radio button
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        country.setAdapter(countryAdapter);

        Spinner gender = findViewById(R.id.gender);
        gender.setOnItemSelectedListener(this);
        List<String> genders = new ArrayList<String>(Arrays.asList("MALE", "FEMALE"));

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genders);

        // Drop down layout style - list view with radio button
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        gender.setAdapter(genderAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void clickToSignIn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void clickToChooseBirthday(View view) {
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(),"DatePicker");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + (month + 1) + "/" + year;
        txtBirthday.setText(date);
    }
}
