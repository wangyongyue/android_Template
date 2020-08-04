package com.example.kuai.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kuai.R;
import com.example.kuai.servers.Server;
import com.example.kuai.views.flowLayout.FlowLayout;
import com.example.kuai.views.linearAdapter.LinearAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DefaultFragment extends Fragment {

    private Server server;
    private LinearAdapter adapter;

    public DefaultFragment(Server server) {
        this.server = server;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main2, container, false);

        final RecyclerView table = (RecyclerView)view.findViewById(R.id.table);
        FlowLayout layout = new FlowLayout(getActivity(),this.server.list);
        layout.scrollDirection = RecyclerView.VERTICAL;
        table.setLayoutManager(layout);
        adapter = new LinearAdapter(getActivity(),this.server.list);
        table.setAdapter(adapter);
        adapter.tableIndex(new LinearAdapter.OnIndexListener() {
            @Override
            public void onIndex(int index) {
                server.tableIndex(index);
                Log.d("fragment",String.format("%s",index));
            }
        });
        this.server.reloadData(new Server.OnDataListener() {
            @Override
            public void reload() {
                reloadData();
            }
        });
        server.networkRequest();
        return view;

    }
    public void reloadData(){

        adapter.notifyDataSetChanged();
    }
}
