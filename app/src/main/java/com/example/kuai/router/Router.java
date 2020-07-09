package com.example.kuai.router;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.example.kuai.controllers.BaseActivity;
import com.example.kuai.servers.Server;

import java.util.ArrayList;
import java.util.List;

public class Router {
    private static Router instance = new Router();
    private static List<Context> activitys = new ArrayList<Context>();

    private Router(){}
    public static Router shared(){
        return instance;
    }

    public void push(Context context){
        activitys.add(context);
    }
    public void pop(){
        activitys.remove(activitys.size() - 1);
    }
    public Context context(){
        return activitys.get(activitys.size() - 1);
    }
}
