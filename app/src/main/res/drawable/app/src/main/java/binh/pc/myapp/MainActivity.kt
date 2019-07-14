package binh.pc.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.ArrayAdapter


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner = findViewById(R.id.spinner) as Spinner;
        val categories = ArrayList<String>()
        categories.add("")
        categories.add("HOME")
        categories.add("MEN")
        categories.add("WOMEN")
        categories.add("ABOUT US")
        categories.add("ADD PRODUCT")
        categories.add("LOGIN/REGISTER")

        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    fun clickToLogin(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun clickToAdd(view: View) {
        val intent = Intent(this, AddProductActivity::class.java)
        startActivity(intent)
    }



}
