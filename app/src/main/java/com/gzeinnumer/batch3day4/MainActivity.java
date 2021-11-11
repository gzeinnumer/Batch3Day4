package com.gzeinnumer.batch3day4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    TextInputEditText edSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        edSearch = findViewById(R.id.ed_search);

        initRV();
    }
    RVAdapter rvAdapter;
    private void initRV() {
        List<President> list = new ArrayList<>();

        list.add(new President("Zein1", "2021-11-11", "Forever"));
        list.add(new President("Zein2", "2021-11-11", "Forever"));
        list.add(new President("Zein3", "2021-11-11", "Forever"));
        list.add(new President("Zein4", "2021-11-11", "Forever"));
        list.add(new President("Zein5", "2021-11-11", "Forever"));
        list.add(new President("Zein6", "2021-11-11", "Forever"));
        list.add(new President("Zein7", "2021-11-11", "Forever"));
        list.add(new President("Zein8", "2021-11-11", "Forever"));
        list.add(new President("Zein9", "2021-11-11", "Forever"));

        rvAdapter = new RVAdapter(list);

        rv.setAdapter(rvAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setHasFixedSize(true); //rv.hasFixedSize();

        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                rvAdapter.getFilter().filter(s.toString());
            }
        });
    }
}