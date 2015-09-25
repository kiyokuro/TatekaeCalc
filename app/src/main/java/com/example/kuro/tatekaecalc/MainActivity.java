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


public class MainActivity extends Activity{
    static ArrayAdapter<String> adapter;
    ListView listView;
    ArrayList<String> formulaList = new ArrayList<String>();
    static ArrayAdapter<String> adapter2;
    ListView listView2;
    ArrayList<String> logList = new ArrayList<String>();
    Calc ca = new Calc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView  �̃Z�b�g
        listView = (ListView)findViewById(R.id.listView);
        //�f�[�^�̒ǉ�
        adapter = new ArrayAdapter<String>(this,R.layout.list_layout,R.id.listText,formulaList);
        //ListView�̃Z�b�g
        listView2 = (ListView)findViewById(R.id.listView2);
        //�f�[�^�̒ǉ�
        adapter2 = new ArrayAdapter<String>(this,R.layout.log_layout,R.id.logText,logList);

        //���X�g�̃A�C�e�����^�b�v�������̏���
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView = (ListView) parent;
                // �N���b�N���ꂽ�A�C�e�����擾���܂�
                String item = (String) listView.getItemAtPosition(position);
                //Toast.makeText(ListViewSampleActivity.this, item, Toast.LENGTH_LONG).show();
                //ca.setViewsb(item);
                ca.setFormula(item);
                tv = (TextView) findViewById(R.id.textView2);
                ca.updateView(view, tv);
            }
        });
        //���X�g�̃A�C�e���𒷉������̏���
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

    /*���X�g�Ɏ���ǉ�����Ƃ��̃{�^�������������̏���*/
    public void addList(View view) {
        String str = ca.getFormula();
        if(str != "") {
//            if(ca.getViewsb().indexOf("+") !=-1 || ca.getViewsb().indexOf("-") !=-1 || ca.getViewsb().indexOf("*") !=-1 || ca.getViewsb().indexOf("/") !=-1){
//                Toast.makeText(this, "You can serve only number", Toast.LENGTH_SHORT).show();
//            }else {
                //formulaList.add(str);
                listView.setAdapter(adapter);
                // �v�f����ԏ�ɒǉ�
                adapter.insert(str, 0);

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
    //��ʂ̃{�^���������ꂽ���̏���
    public void viewNumber(View view){
        tv = (TextView)findViewById(R.id.textView2);
        //TextView logtv = (TextView)findViewById(R.id.log);//�e�X�g�p
        //ca.calc(view,tv,logtv,adapter2,listView2);//�����̕\���A�v�Z
        ca.calc(view,tv,adapter2,listView2);
    }

    public void addLog(String str){
        listView2.setAdapter(adapter2);
        // �v�f����ԏ�ɒǉ�
        adapter2.insert(str, 0);
    }
}
