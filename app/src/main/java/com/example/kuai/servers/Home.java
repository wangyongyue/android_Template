package com.example.kuai.servers;

import com.example.kuai.views.cells.LinearModel;

public class Home extends Server {

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
