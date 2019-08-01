package com.example.searchviewbasico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Adapter adapter;
    private List<Item> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    fillExampleList();
    setUpRecyclerView();
}

    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new Item("https://cdn.icon-icons.com/icons2/97/PNG/128/brazil_flags_flag_16979.png", "Brasil", "Brazil"));
        exampleList.add(new Item("https://cdn.icon-icons.com/icons2/97/PNG/128/united_states_flags_flag_17080.png", "USA", "EUA"));
        exampleList.add(new Item("https://cdn.icon-icons.com/icons2/97/PNG/128/spain_flags_flag_17068.png", "Espanha", "Spain"));
        exampleList.add(new Item("https://cdn.icon-icons.com/icons2/97/PNG/128/brazil_flags_flag_16979.png", "Four", "Thirteen"));
        exampleList.add(new Item("https://cdn.icon-icons.com/icons2/97/PNG/128/brazil_flags_flag_16979.png", "Five", "Fourteen"));
        exampleList.add(new Item("https://cdn.icon-icons.com/icons2/97/PNG/128/brazil_flags_flag_16979.png", "Six", "Fifteen"));
        exampleList.add(new Item("https://cdn.icon-icons.com/icons2/97/PNG/128/brazil_flags_flag_16979.png", "Seven", "Sixteen"));
        exampleList.add(new Item("https://cdn.icon-icons.com/icons2/97/PNG/128/brazil_flags_flag_16979.png", "Eight", "Seventeen"));
        exampleList.add(new Item("https://cdn.icon-icons.com/icons2/97/PNG/128/brazil_flags_flag_16979.png", "Nine", "Eighteen"));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new Adapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}


