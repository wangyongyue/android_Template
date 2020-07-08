package com.example.kuai.router;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.example.kuai.servers.Server;

import java.util.ArrayList;
import java.util.List;

public class Router {
    private static Router instance = new Router();
    private static List<Server> servers = new ArrayList<Server>();
    private static List<Context> activitys = new ArrayList<Context>();

    private Router(){}
    public static Router shared(){
        return instance;
    }

    public void push(int server){
        if (activitys.size() == 0){return;}
        Context context = activitys.get(activitys.size() - 1);

        try {

            String classStr = context.getString(server);
            Class<?> classd = Class.forName(classStr);
            Server se = (Server) classd.newInstance();
            servers.add(se);

//            Intent intent = new Intent(context, se.controller());
//            context.startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
    public void push(int server,Object params) {
        if (activitys.size() == 0){return;}
        Context context = activitys.get(activitys.size() - 1);


    }
    public void pop(){

        if (activitys.size() == 0){return;}
        Context context = activitys.get(activitys.size() - 1);
        Intent intent = new Intent();
        AppCompatActivity activity =  (AppCompatActivity)context;
        activity.setResult(1,intent);
        activity.finish();

        activitys.remove(activitys.size() - 1);
        servers.remove(servers.size() - 1);

    }
    public void context(Context context){
        activitys.add(context);
    }
    public Server server(){
        if (servers.size() == 0){
            return new Server();
        }
        return servers.get(servers.size() - 1);
    }
}
