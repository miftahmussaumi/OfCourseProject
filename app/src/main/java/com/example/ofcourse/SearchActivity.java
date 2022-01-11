package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import com.example.ofcourse.api.ApiClient;
import com.example.ofcourse.api.ApiInterface;

import java.util.List;

import Adapter.MenuAdapter;
import Adapter.SearchAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {

    private SearchAdapter adapter;
    private SearchView searchView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView = findViewById(R.id.rvSearch);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CallRetrofit();
    }

    private void CallRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ofcourse2.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<responsemodelsearch>> call = apiInterface.getGuru();
        call.enqueue(new Callback<List<responsemodelsearch>>() {
            @Override
            public void onResponse(Call<List<responsemodelsearch>> call, Response<List<responsemodelsearch>> response) {

                if (response.isSuccessful()){
                    List<responsemodelsearch> guru = response.body();
                    adapter = new SearchAdapter(SearchActivity.this, guru);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<responsemodelsearch>> call, Throwable t) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() > 0){
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://ofcourse2.herokuapp.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();



                    ApiInterface apiInterface = retrofit.create(ApiInterface.class);
                    Call<List<responsemodelsearch>> call = apiInterface.getQuery(newText);
                    call.enqueue(new Callback<List<responsemodelsearch>>() {
                        @Override
                        public void onResponse(Call<List<responsemodelsearch>> call, Response<List<responsemodelsearch>> response) {

                            if (response.isSuccessful()){
                                List<responsemodelsearch> guru = response.body();
                                adapter = new SearchAdapter(SearchActivity.this, guru);
                                recyclerView.setAdapter(adapter);
                            }
                        }

                        @Override
                        public void onFailure(Call<List<responsemodelsearch>> call, Throwable t) {

                        }
                    });
                }
                return true;
            }
        });
        return  super.onCreateOptionsMenu(menu);
    }

}