package com.example.kuai.servers.main;

import android.content.Context;
import android.content.Intent;
import com.example.kuai.router.Router;
import com.example.kuai.servers.Server;
import com.example.kuai.servers.details.DetailsActivity;
import com.example.kuai.servers.main.MainActivity;
import com.example.kuai.views.cells.LinearModel;

public class Search extends Server {

    @Override
    public void loadTableData(Object reponse){

        for(int i=0;i<30;i++){

            LinearModel m = new LinearModel();
            m.name = String.format("Home%s-%s", i/10+1,i);
            list.add(m);
        }
    }
    @Override
    public void tableIndex(int index){

        Context context = Router.shared().context();
        Intent intent = new Intent(context, DetailsActivity.class);
        context.startActivity(intent);
    }

}
