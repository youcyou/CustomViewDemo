package com.example.youcyou.customviewdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.youcyou.customviewdemo.view.HorizontalScrollViewEx;

import java.util.ArrayList;

/**
 * 显示viewgroup 的activity
 *
 * @since 16/7/14.
 */
public class ViewGroupActivity extends Activity {

    private HorizontalScrollViewEx mListContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewgroup);

       initView();
    }

    private  void initView(){
        mListContainer = (HorizontalScrollViewEx) findViewById(R.id.list_container);
        for (int i = 0; i < 3; i++) {
            ViewGroup layout = (ViewGroup) getLayoutInflater().inflate(
                    R.layout.content_layout, mListContainer, false);
            layout.getLayoutParams().width = getWindowManager().getDefaultDisplay().getWidth();
            TextView textView = (TextView) layout.findViewById(R.id.title);
            textView.setText("page " + (i + 1));
            layout.setBackgroundColor(Color.rgb(255 / (i + 1), 255 / (i + 1), 0));
            createList(layout);
            mListContainer.addView(layout);
        }
    }

    private void createList(ViewGroup layout) {
        ListView listView = (ListView) layout.findViewById(R.id.list);
        ArrayList<String> datas = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            datas.add("name " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.content_list_item, R.id.name, datas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ViewGroupActivity.this, "click item",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

}
