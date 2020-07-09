package com.example.kuai.servers.details;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.kuai.controllers.DefaultActivity;

public class DetailsActivity extends DefaultActivity {

    public DetailsActivity(){
        this.server = new Details();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
