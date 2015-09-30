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

import java.util.ArrayList;

import de.timroes.android.listview.EnhancedListView;


public class MainActivity extends Activity{
    static ArrayAdapter<String> adapter;
    //ListView listView;
    EnhancedListView listView;
    ArrayList<String> formulaList = new ArrayList<String>();
    static ArrayAdapter<String> adapter2;
    ListView listView2;
    ArrayList<String> logList = new ArrayList<String>();
    Calc ca = new Calc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView  のセット
        listView = (EnhancedListView)findViewById(R.id.listView);
        //データの追加
        adapter = new ArrayAdapter<String>(this,R.layout.list_layout,R.id.listText,formulaList);
        //ListViewのセット
        listView2 = (ListView)findViewById(R.id.listView2);
        //データの追加
        adapter2 = new ArrayAdapter<String>(this,R.layout.log_layout,R.id.logText,logList);

        //リストのアイテムをタップした時の処理
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView = (EnhancedListView) parent;
                // クリックされたアイテムを取得します
                String item = (String) listView.getItemAtPosition(position);
                //Toast.makeText(ListViewSampleActivity.this, item, Toast.LENGTH_LONG).show();
                //ca.setViewsb(item);
                ca.setFormula(item);
                tv = (TextView) findViewById(R.id.textView2);
                ca.updateView(view, tv);

            }
        });
        // スワイプで消す設定
        listView.setDismissCallback(new de.timroes.android.listview.EnhancedListView.OnDismissCallback() {
            @Override
            public EnhancedListView.Undoable onDismiss(EnhancedListView listView, final int position) {

                final String item = (String) adapter.getItem(position);
                /// 消す処理
                //mItemList.remove(position);
                adapter.remove(adapter.getItem(position));
                adapter.notifyDataSetChanged();
                /*return new EnhancedListView.Undoable() {
                    @Override
                    public void undo() {
                        // 元に戻す処理
                        formulaList.add(position, item);
                        adapter.notifyDataSetChanged();
                    }
                };*/
                return null;
            }
        });
        listView.enableSwipeToDismiss();
    }
    //リストのアイテムを削除する
    public void removeListItem(View view ){
        int position = 0;
        String item = (String) adapter.getItem(position);
        adapter.remove(adapter.getItem(position));
        adapter.notifyDataSetChanged();
    }
    /*リストに式を追加するときのボタンを押した時の処理*/
    public void addList(View view) {
        String str = ca.getFormula();
        if(str != "") {
//            if(ca.getViewsb().indexOf("+") !=-1 || ca.getViewsb().indexOf("-") !=-1 || ca.getViewsb().indexOf("*") !=-1 || ca.getViewsb().indexOf("/") !=-1){
//                Toast.makeText(this, "You can serve only number", Toast.LENGTH_SHORT).show();
//            }else {
                //formulaList.add(str);
                listView.setAdapter(adapter);
                // 要素を一番上に追加
                adapter.insert(str, 0);
                //メモリの要素の数が20を超えたら古いものから消していく
                if(listView.getCount() > 20){
                    adapter.remove(adapter.getItem(20));
                }
//            }
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
        //is_scroll = true;
        //TextView logtv = (TextView)findViewById(R.id.log);//テスト用
        //ca.calc(view,tv,logtv,adapter2,listView2);//数字の表示、計算
        ca.calc(view,tv,adapter2,listView2);
    }

    public void addLog(String str) {
        listView2.setAdapter(adapter2);
        // 要素を一番上に追加
        adapter2.insert(str, 0);
    }
}
