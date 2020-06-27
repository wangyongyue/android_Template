package com.example.kuai.views.cells;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kuai.R;

public class NavItem {
    public String name;

    public int identifier(){
        return R.layout.layout_nav;
    }
    public RecyclerView.ViewHolder holder(View itemView){ return new NavHolder(itemView); }

    class NavHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public NavHolder(View itemView){
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.nav_item);
        }
        public void loadModel(Object obj){
            NavItem model = (NavItem)obj;
            textView.setText(model.name);
        }
    }
}
