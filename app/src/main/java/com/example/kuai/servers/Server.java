package com.example.kuai.servers;

import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public List<Object> list = new ArrayList<>();
    public String error;
    public Server.OnDataListener listener;
    public String url(){return "";}
    public FormBody body(){
            FormBody body = new FormBody.Builder()
//            .add("a","b")
            .build();
        return body;
    }
    public List<Object> getList() {return list;}
    public void loadTableData(Object reponse){}
    public void loadError(String error){}
    public void tableIndex(int index){}
    public void reloadData(Server.OnDataListener l){ listener = l; };
    public void networkRequest(){
        if (url().length() == 0){
            loadTableData(null);
            listener.reload();
            return;
        }else {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url())
                    .post(body())
                    .build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    loadError("网络错误");
                    listener.reload();
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if(response.isSuccessful()){
                        String result = response.body().string();
                        //处理UI需要切换到UI线程处理
                        loadTableData(response.body());
                        listener.reload();
                    }
                }
            });
        }
    }

    public interface OnDataListener {
        void reload();
    }


}
