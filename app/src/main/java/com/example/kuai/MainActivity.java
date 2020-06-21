package com.example.kuai;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kuai.controllers.Main2Activity;
import com.example.kuai.servers.Server;
import com.example.kuai.views.flowLayout.FlowLayout;
import com.example.kuai.views.linearAdapter.LinearAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Server server = new Server();
        List<Object> list = server.loadTableData(null);


        RecyclerView table = (RecyclerView)findViewById(R.id.table);
        FlowLayout layout = new FlowLayout(this,list);
        layout.scrollDirection = server.scrollDirection();
        table.setLayoutManager(layout);
        LinearAdapter adapter = new LinearAdapter(this,list);
        table.setAdapter(adapter);
        adapter.tableIndex(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("dsdf",String.format("%s",i));

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("server","server");
                startActivity(intent);
            }
        });


    }
}
