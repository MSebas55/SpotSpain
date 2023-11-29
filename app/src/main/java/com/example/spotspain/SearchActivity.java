package com.example.spotspain;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.spotspain.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] provincias = getResources().getStringArray(R.array.Provincia);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.list_item, provincias);

        String[] municipios = getResources().getStringArray(R.array.Municipio);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.list_item, municipios);

        String[] intereses = getResources().getStringArray(R.array.Interes);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, R.layout.list_item, intereses);

        AutoCompleteTextView autoCompleteTextView1 = binding.autoCompleteTextView1;
        autoCompleteTextView1.setAdapter(adapter1);

        AutoCompleteTextView autoCompleteTextView2 = binding.autoCompleteTextView2;
        autoCompleteTextView2.setAdapter(adapter2);

        AutoCompleteTextView autoCompleteTextView3 = binding.autoCompleteTextView3;
        autoCompleteTextView3.setAdapter(adapter3);
    }
    public void volverinicio() {
        Intent nIntent = new Intent(SearchActivity.this, Inicio.class);
        startActivity(nIntent);
    }
}