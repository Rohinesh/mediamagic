package com.rohini.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.rohini.homepage.adapter.GridViewAdapter;
import com.rohini.homepage.api.MyAPIService;
import com.rohini.homepage.api.RetrofitClientInstance;
import com.rohini.homepage.bean.Bookbean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    GridView gridView;
    List<Bookbean> list;
    private GridViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MyAPIService myAPIService = RetrofitClientInstance.getRetrofitInstance().create(MyAPIService.class);
        Call<List<Bookbean>> call=myAPIService.getBookList();
        call.enqueue(new Callback<List<Bookbean>>() {
            @Override
            public void onResponse(Call<List<Bookbean>> call, Response<List<Bookbean>> response) {
                populateGridView(response.body());
            }

            @Override
            public void onFailure(Call<List<Bookbean>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Not Found", Toast.LENGTH_LONG).show();

            }
        });

    }
    private void populateGridView(final List<Bookbean> list) {
        gridView=findViewById(R.id.grideview);
        adapter = new GridViewAdapter(this,list);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Id=list.get(position).getId();
                Intent intent=new Intent(getApplicationContext(),SecondScreen.class);
                intent.putExtra("id",Id);
                startActivity(intent);
            }
        });




    }

}