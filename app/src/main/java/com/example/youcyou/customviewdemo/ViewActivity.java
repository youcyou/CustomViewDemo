package com.example.youcyou.customviewdemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * 显示view 的activity
 *
 * @since 16/7/14.
 */
public class ViewActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }
}
