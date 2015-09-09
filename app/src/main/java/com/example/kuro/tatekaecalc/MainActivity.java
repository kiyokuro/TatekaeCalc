package com.example.kuro.tatekaecalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        //リストのアイテムをタップした時の処理
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView = (ListView) parent;
                // クリックされたアイテムを取得します
                String item = (String) listView.getItemAtPosition(position);
                //Toast.makeText(ListViewSampleActivity.this, item, Toast.LENGTH_LONG).show();
                ca.setViewsb(item);
                tv = (TextView) findViewById(R.id.textView2);
                ca.updateView(view, tv);
            }
        });
        //リストのアイテムを長押し時の処理
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) adapter.getItem(position);
                adapter.remove(adapter.getItem(position));
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    /*リストに式を追加するときのボタンを押した時の処理*/
    public void addList(View view) {
        String str = ca.getViewsb();
        if(str != "") {
            if(ca.getViewsb().indexOf("+") !=-1 || ca.getViewsb().indexOf("-") !=-1 || ca.getViewsb().indexOf("*") !=-1 || ca.getViewsb().indexOf("/") !=-1){
                Toast.makeText(this, "You can serve only number", Toast.LENGTH_SHORT).show();
            }else {
                formulaList.add(str);
                listView.setAdapter(adapter);
            }
        }
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
    TextView tv;
    //画面のボタンが押された時の処理
    public void viewNumber(View view){
        tv = (TextView)findViewById(R.id.textView2);
        TextView logtv = (TextView)findViewById(R.id.textView1);//テスト用
        ca.calc(view,tv,logtv);//数字の表示、計算
    }
}
