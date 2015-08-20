package com.example.kuro.tatekaecalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity{
    static ArrayAdapter<String> adapter;
    ListView listView;
    ArrayList<String> formulaList = new ArrayList<String>();
    Calc ca = new Calc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListViewのセット
        listView = (ListView)findViewById(R.id.listView);
        //データの追加
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,formulaList);
    }
    /*リストに式を追加するときのボタンを押した時の処理*/
    public void addList(View view) {
        String str = ca.getViewsb();
        formulaList.add(str);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //画面のボタンが押された時の処理
    public void viewNumber(View view){
        TextView tv = (TextView)findViewById(R.id.textView2);
        TextView testtv = (TextView)findViewById(R.id.textView1);//テスト用
        ca.calc(view,tv,testtv);//数字の表示、計算
    }

}
