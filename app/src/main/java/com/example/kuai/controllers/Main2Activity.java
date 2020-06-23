package com.example.kuai.controllers;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kuai.R;
import com.example.kuai.router.Router;
import com.example.kuai.servers.Server;
import com.example.kuai.views.flowLayout.FlowLayout;
import com.example.kuai.views.linearAdapter.LinearAdapter;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Router.shared().context(Main2Activity.this);

        Server server = Router.shared().server();
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
                Router.shared().pop();
            }
        });




    }
}
