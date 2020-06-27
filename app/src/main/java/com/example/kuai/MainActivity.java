package com.example.kuai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.kuai.controllers.DefaultFragment;
import com.example.kuai.router.Router;
import com.example.kuai.servers.Home;
import com.example.kuai.servers.Mine;
import com.example.kuai.servers.Search;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Router.shared().context(MainActivity.this);



        final DefaultFragment fragment = new DefaultFragment(new Home());
        final DefaultFragment fragment1 = new DefaultFragment(new Search());
        final DefaultFragment fragment2 = new DefaultFragment(new Mine());
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.main_container,fragment);
        ft.commit();


        Button home = (Button) findViewById(R.id.one);
        Button search = (Button) findViewById(R.id.two);
        Button mine = (Button) findViewById(R.id.three);

        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.main_container,fragment);
                ft.commit();

            }
        });

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.main_container,fragment1);
                ft.commit();

            }
        });

        mine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.main_container,fragment2);
                ft.commit();

            }
        });


    }
}
