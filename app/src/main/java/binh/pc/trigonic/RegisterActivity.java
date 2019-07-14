package binh.pc.trigonic;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener{
    TextView txtBirthday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtBirthday = findViewById(R.id.txtBirthday);

        Spinner country = (Spinner) findViewById(R.id.country);
        country.setOnItemSelectedListener(this);
        List<String> countryLists = new ArrayList<String>();
        countryLists.add("Vietnam");
        countryLists.add("Afghanistan");
        countryLists.add("Albania");
        countryLists.add("American Samoa");
        countryLists.add("Andorra");
        countryLists.add("Angola");
        countryLists.add("Anguilla");
        countryLists.add("Australia");
        countryLists.add("Brazil");
        countryLists.add("Brunei Darussalam");
        countryLists.add("British Indian Ocean Territory");
        countryLists.add("Bulgaria");
        countryLists.add("Cambodia");
        countryLists.add("Canada");
        countryLists.add("China Mainland ");
        countryLists.add("Colombia");
        countryLists.add("Cuba");
        countryLists.add("Cyprus");
        countryLists.add("Czech Republic");
        countryLists.add("Ethiopia");
        countryLists.add("European Union");
        countryLists.add("France");
        countryLists.add("French Southern Territories");
        countryLists.add("Germany");
        countryLists.add("Grenada");
        countryLists.add("Hong Kong");
        countryLists.add("India");
        countryLists.add("Indonesia");
        countryLists.add("Italy");
        countryLists.add("Japan");
        countryLists.add("Korea, Republic of");
        countryLists.add("Liberia");
        countryLists.add("Macau");
        countryLists.add("Mexico");
        countryLists.add("New Zealand");
        countryLists.add("Peru");
        countryLists.add("Philippines");
        countryLists.add("Qatar");
        countryLists.add("Singapore");
        countryLists.add("Taiwan");
        countryLists.add("United Kingdom");
        countryLists.add("United States");
        countryLists.add("Virgin Islands (British)");
        countryLists.add("Zimbabwe");



        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countryLists);

        // Drop down layout style - list view with radio button
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        country.setAdapter(countryAdapter);

        Spinner gender = (Spinner) findViewById(R.id.gender);
        gender.setOnItemSelectedListener(this);
        List<String> genders = new ArrayList<String>();
        genders.add("MALE");
        genders.add("FEMALE");


        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genders);

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
        dateFragment.show(getFragmentManager(),"DatePicker");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + (month + 1) + "/" + year;
        txtBirthday.setText(date);
    }
}
