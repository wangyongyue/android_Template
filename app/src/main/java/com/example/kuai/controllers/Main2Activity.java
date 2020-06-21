package com.example.kuai.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kuai.R;
import com.example.kuai.views.cells.LinearModel;
import com.example.kuai.views.flowLayout.FlowLayout;
import com.example.kuai.views.linearAdapter.LinearAdapter;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Object> list=new ArrayList<>();
        for(int i=0;i<30;i++){
            LinearModel m = new LinearModel();
            m.name = String.format("%s-%s", i/10+1,i);
            list.add(m);
        }

        RecyclerView table = (RecyclerView)findViewById(R.id.table);
        table.setLayoutManager(new FlowLayout(this,list));
        table.setAdapter(new LinearAdapter(this,list));

        Intent intent = getIntent();
        Log.d("push",intent.getStringExtra("server"));


    }
}
