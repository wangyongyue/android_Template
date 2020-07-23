package com.example.kuai.controllers;

import android.os.Bundle;
import com.example.kuai.base.DefaultActivity;
import com.example.kuai.servers.main.Details;

public class DetailsActivity extends DefaultActivity {

    public DetailsActivity(){
        this.server = new Details();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
