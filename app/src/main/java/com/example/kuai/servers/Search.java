package com.example.kuai.servers;

import com.example.kuai.views.cells.NavItem;

import java.util.ArrayList;
import java.util.List;

public class Search extends Server{

    @Override
    public List<Object> loadTableData(Object reponse){

        List<Object> list=new ArrayList<>();
        for(int i=0;i<30;i++){

            NavItem m = new NavItem();
            m.name = String.format("Search%s-%s", i/10+1,i);
            list.add(m);
        }
        return list;
    }
    @Override
    public void tableIndex(int index){

    }

}
