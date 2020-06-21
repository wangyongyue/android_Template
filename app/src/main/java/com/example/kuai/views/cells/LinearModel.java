package com.example.kuai.views.cells;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kuai.R;

public class LinearModel {
    public String name;
    public int identifier(){
        return R.layout.layout_linear_item;
    }
    public RecyclerView.ViewHolder holder(View itemView){
        return new LinearViewHolder(itemView);
    }
}
