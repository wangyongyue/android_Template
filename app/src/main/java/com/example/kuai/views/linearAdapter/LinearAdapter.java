package com.example.kuai.views.linearAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{
    //context
    private Context mContext;
    //展示的数据
    private List<Object> list;
    private AdapterView.OnItemClickListener onItemClickListener;
    public LinearAdapter(Context context,List<Object> list){
        this.mContext=context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Object obj =  this.list.get(viewType);
        RecyclerView.ViewHolder holder = null;
        try {
            Method method = obj.getClass().getDeclaredMethod("identifier",new  Class[0]);
            int identifier = (int) method.invoke(obj,new Object[]{});

            View view = LayoutInflater.from(mContext).inflate(identifier,parent,false);
            Method holderMethod = obj.getClass().getDeclaredMethod("holder",View.class);
            holder = (RecyclerView.ViewHolder) holderMethod.invoke(obj,view);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return holder;

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Object obj =  this.list.get(position);
        try {
            Method method = holder.getClass().getDeclaredMethod("loadModel",Object.class);
            method.invoke(holder,obj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            AdapterView.OnItemClickListener listener = onItemClickListener;
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(null,null,position,0);
            }
        });
    }
    public void tableIndex(AdapterView.OnItemClickListener onItemClickListener){

        this.onItemClickListener = onItemClickListener;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



}
