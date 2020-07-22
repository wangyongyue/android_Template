package com.example.kuai.servers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {
    public List<Object> list = new ArrayList<>();
    public Server.OnDataListener listener;
    public String url(){return "";}
    public HashMap body(){return new HashMap();}
    public List<Object> getList() {return list;}
    public void loadTableData(Object reponse){}
    public void tableIndex(int index){}
    public void reloadData(Server.OnDataListener l){ listener = l; };
    public void networkRequest(){
        if (url().length() == 0){
            loadTableData(null);
            listener.reload();
            return;
        }
    };

    public interface OnDataListener {
        void reload();
    }


}
