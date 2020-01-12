package id.ac.poliban.mi.listcountry;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Country> countries = new ArrayList<>();
    private ListView lvCountry;
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCountry = findViewById(R.id.listview);

        countries.addAll(CountryData.getAllCountries());

        adapter = new CountryAdapter(countries);

        lvCountry.setAdapter(adapter);

        lvCountry.setOnItemClickListener(((parent, view, position, id) -> {
            new AlertDialog.Builder(this)
                    .setTitle("Negara Yang Anda Pilih")
                    .setMessage("Anda Memilih: " +
                            countries.get(position).getCountryName())
                    .setPositiveButton("OK", null).show();
        }));
    }
}
