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
import java.util.List;


public class MainActivity extends Activity{
    static List<String> dataList = new ArrayList<String>();
    static ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAdapter();
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

    protected void setAdapter(){
        ListView lv = (ListView) findViewById(R.id.listView1);
        adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, dataList);
        lv.setAdapter(adapter);
    }

    //画面のボタンが押された時の処理
    CalcActivity ca = new CalcActivity();
    public void viewNumber(View view){
        TextView tv = (TextView)findViewById(R.id.textView2);
        TextView testtv = (TextView)findViewById(R.id.textView1);//テスト用
        ca.calc(view,tv,testtv);//数字の表示、計算
    }
    /*ListViewの処理*/
    ListActivity la = new ListActivity();
    public void viewList(View view){
        la.numStore(view);
    }

}
