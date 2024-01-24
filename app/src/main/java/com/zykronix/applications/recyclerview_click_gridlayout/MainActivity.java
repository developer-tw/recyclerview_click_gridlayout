package com.zykronix.applications.recyclerview_click_gridlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    RecyclerViewAdapter adapter;

    private final RecyclerViewAdapter.OnItemClick onItemClick = (scanResult, position) -> {
        Log.d("DEBUG", "OnItemClick() - name: " + scanResult.getTitle());
        Log.d("DEBUG", "OnItemClick() - position: " + position);
        adapter.setSelected(position);
        adapter.notifyDataSetChanged();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.idCourseRV);

        // created new array list..
        recyclerDataArrayList=new ArrayList<>();

        // added data to array list
        recyclerDataArrayList.add(new RecyclerData("DSA",R.drawable.ic_device_apple_music));
        recyclerDataArrayList.add(new RecyclerData("JAVA",R.drawable.ic_device_apple_music));
        recyclerDataArrayList.add(new RecyclerData("C++",R.drawable.ic_device_apple_music));
        recyclerDataArrayList.add(new RecyclerData("Python",R.drawable.ic_device_apple_music));
        recyclerDataArrayList.add(new RecyclerData("Node Js",R.drawable.ic_device_apple_music));
        recyclerDataArrayList.add(new RecyclerData("JavaScript",R.drawable.ic_device_apple_music));
        recyclerDataArrayList.add(new RecyclerData("Golang",R.drawable.ic_device_apple_music));
        recyclerDataArrayList.add(new RecyclerData("React",R.drawable.ic_device_apple_music));

        // added data from arraylist to adapter class.
        adapter=new RecyclerViewAdapter(recyclerDataArrayList,this);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.onItemClick = onItemClick;
    }
}