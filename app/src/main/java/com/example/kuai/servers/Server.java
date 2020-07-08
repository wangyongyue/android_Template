package com.example.kuai.servers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {
    public List<Object> list;

    public String url(){return "";}
    public HashMap body(){return new HashMap();}

    public Server(){
        list = new ArrayList<>();
    }

    public List<Object> getList() {
        if (list == null){
            return new ArrayList<>();
        }
        return list;
    }

    public void loadTableData(Object reponse){

    }
    public void tableIndex(int index){

    }

}
