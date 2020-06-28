package com.example.kuai.servers;

import androidx.recyclerview.widget.RecyclerView;
import com.example.kuai.controllers.DefaultActivity;
import com.example.kuai.views.cells.LinearModel;
import com.example.kuai.views.cells.NavItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {
    public Object obj;
    public String url(){return "";}
    public HashMap body(){return new HashMap();}
    public Class controller(){ return DefaultActivity.class;}
    public int scrollDirection(){return RecyclerView.VERTICAL; }
    public List<Object> loadNavigationData(Object reponse){

        List<Object> list=new ArrayList<>();
        NavItem m = new NavItem();
        m.name = String.format("main");
        list.add(m);
        return list;
    }
    public void navgationIndex(int index){



    }
    public List<Object> loadTableData(Object reponse){

        List<Object> list=new ArrayList<>();
        for(int i=0;i<30;i++){

            LinearModel m = new LinearModel();
            m.name = String.format("%s-%s", i/10+1,i);
            list.add(m);
        }
        return list;
    }
    public void tableIndex(int index){

    }

}
