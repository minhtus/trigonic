package binh.pc.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class AddProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
        val brand = findViewById(R.id.brand) as Spinner;
        val brandLists = ArrayList<String>()
        brandLists.add("Adidas")
        brandLists.add("Alexander McQueen")
        brandLists.add("Balenciaga")
        brandLists.add("Balmain")
        brandLists.add("Boss Hugo Boss")
        brandLists.add("Bulgari")
        brandLists.add("Burberry")
        brandLists.add("Cartier")
        brandLists.add("Dior")
        brandLists.add("Dolce & Gabbana")
        brandLists.add("Dr.Martens")
        brandLists.add("Dsquared2")
        brandLists.add("Fendi")
        brandLists.add("Geox")
        brandLists.add("Givenchy")
        brandLists.add("Greg Lauren")
        brandLists.add("Gucci")
        brandLists.add("Guidi")
        brandLists.add("Hermès")
        brandLists.add("Jimmy Choo")
        brandLists.add("Kenzo")
        brandLists.add("Louis Vuitton")
        brandLists.add("Levi's")
        brandLists.add("Marc By Marc Jacobs")
        brandLists.add("MCM")
        brandLists.add("McQ Alexander McQueen")
        brandLists.add("Moschino")
        brandLists.add("Neil Barrett")
        brandLists.add("New Balance")
        brandLists.add("Nike")
        brandLists.add("Oakley")
        brandLists.add("Off-White")
        brandLists.add("Palm Angels")
        brandLists.add("Philipp Plein")
        brandLists.add("Prada")
        brandLists.add("Puma")
        brandLists.add("Raf Simons")
        brandLists.add("Rick Owen")
        brandLists.add("Supreme")
        brandLists.add("The North Face (TNF)")
        brandLists.add("Thom Browne")
        brandLists.add("Tom Ford")
        brandLists.add("Vans")
        brandLists.add("Venyx")
        brandLists.add("Versace")
        brandLists.add("Vogue")
        brandLists.add("Valentino")


        val brandAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, brandLists);
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        brand.setAdapter(brandAdapter);



    }
}
