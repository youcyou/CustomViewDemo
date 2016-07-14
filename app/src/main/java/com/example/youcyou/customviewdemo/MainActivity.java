package com.example.youcyou.customviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button viewButton,viewGroupButton,viewGroupButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewButton = (Button) findViewById(R.id.view);
        viewGroupButton = (Button) findViewById(R.id.viewgroup);
        viewGroupButton2 = (Button) findViewById(R.id.viewgroup2);

        viewButton.setOnClickListener(this);
        viewGroupButton.setOnClickListener(this);
        viewGroupButton2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view:
                startActivity(new Intent(MainActivity.this,ViewActivity.class));
                break;
            case R.id.viewgroup:
                startActivity(new Intent(MainActivity.this,ViewGroupActivity.class));
                break;
            case R.id.viewgroup2:
                startActivity(new Intent(MainActivity.this,ViewGroupActivity2.class));
                break;
        }
    }
}
