package com.example.kuai.base;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kuai.R;
import com.example.kuai.servers.Server;
import com.example.kuai.views.flowLayout.FlowLayout;
import com.example.kuai.views.linearAdapter.LinearAdapter;

public class DefaultActivity extends BaseActivity {
    public Server server;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView table = (RecyclerView)findViewById(R.id.table);
        FlowLayout layout = new FlowLayout(this,this.server.list);
        layout.scrollDirection =  RecyclerView.VERTICAL;
        table.setLayoutManager(layout);
        final LinearAdapter adapter = new LinearAdapter(this,this.server.list);
        table.setAdapter(adapter);
        adapter.tableIndex(new LinearAdapter.OnIndexListener() {
            @Override
            public void onIndex(int index) {
                server.tableIndex(index);
            }
        });
        this.server.reloadData(new Server.OnDataListener() {
            @Override
            public void reload() {
                adapter.notifyDataSetChanged();
            }
        });
        server.networkRequest();


    }
}
