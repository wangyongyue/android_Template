package com.example.kuai.servers.main;

import com.example.kuai.servers.Server;
import com.example.kuai.views.cells.LinearModel;

public class Mine extends Server {

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

    }
}
