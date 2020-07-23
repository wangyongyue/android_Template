package com.example.kuai.base;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.kuai.router.Router;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Router.shared().push(BaseActivity.this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Router.shared().pop();
    }
}
