package com.example.kuai.views.cells;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kuai.R;

public class LinearModel {
    public String name;

    public int identifier(){
        return R.layout.layout_linear_item;
    }
    public RecyclerView.ViewHolder holder(View itemView){ return new LinearViewHolder(itemView); }
    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public LinearViewHolder(View itemView){
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.tv_main);
        }
        public void loadModel(Object obj){
            LinearModel model = (LinearModel)obj;
            textView.setText(model.name);
        }
    }
}
