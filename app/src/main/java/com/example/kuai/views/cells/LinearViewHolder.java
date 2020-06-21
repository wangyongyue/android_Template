package com.example.kuai.views.cells;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kuai.R;

public class LinearViewHolder extends RecyclerView.ViewHolder{
    private TextView textView;
    public LinearViewHolder(View itemView){
        super(itemView);
        textView=(TextView) itemView.findViewById(R.id.tv_main);


    }
    public void loadModel(Object obj){
        textView.setText("sdfsd");
    }
}