package com.example.kuro.tatekaecalc;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    private StringBuilder viewsb = new StringBuilder();//表示用
    private StringBuilder calcsb = new StringBuilder();//計算用
    int operator = 0;//演算子を保存
    private int[] calcvalues = new int[2];
    boolean onetime = true;
    boolean equaled = false;
    public void viewNumber(View view){
        TextView tv = (TextView)findViewById(R.id.textView2);
        TextView testtv = (TextView)findViewById(R.id.textView1);//テスト用

        switch(view.getId()){
            case R.id.number0 :
                if(equaled == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    onetime = true;
                    equaled = false;
                }
                if(viewsb.length()==0)
                    break;
                calcsb.append(0);
                viewsb.append(0);
                calcvalues[1] = Integer.parseInt(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number1 :
                if(equaled == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    onetime = true;
                    equaled = false;
                }
                viewsb.append(1);
                calcsb.append(1);
                calcvalues[1] = Integer.parseInt(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number2 :
                if(equaled == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    onetime = true;
                    equaled = false;
                }
                viewsb.append(2);
                calcsb.append(2);
                calcvalues[1] = Integer.parseInt(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number3 :
                if(equaled == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    onetime = true;
                    equaled = false;
                }
                viewsb.append(3);
                calcsb.append(3);
                calcvalues[1] = Integer.parseInt(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number4 :
                if(equaled == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    onetime = true;
                    equaled = false;
                }
                viewsb.append(4);
                calcsb.append(4);
                calcvalues[1] = Integer.parseInt(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number5 :
                if(equaled == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    onetime = true;
                    equaled = false;
                }
                viewsb.append(5);
                calcsb.append(5);
                calcvalues[1] = Integer.parseInt(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number6 :
                if(equaled == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    onetime = true;
                    equaled = false;
                }
                viewsb.append(6);
                calcsb.append(6);
                calcvalues[1] = Integer.parseInt(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number7 :
                if(equaled == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    onetime = true;
                    equaled = false;
                }
                viewsb.append(7);
                calcsb.append(7);
                calcvalues[1] = Integer.parseInt(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number8 :
                if(equaled == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    onetime = true;
                    equaled = false;
                }
                viewsb.append(8);
                calcsb.append(8);
                calcvalues[1] = Integer.parseInt(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number9 :
                if(equaled == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    onetime = true;
                    equaled = false;
                }
                viewsb.append(9);
                calcsb.append(9);
                calcvalues[1] = Integer.parseInt(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.plus :
                operator = 1;
                if(onetime==true) {
                    calcvalues[0] = calcvalues[1];
                    onetime = false;
                }
                viewsb.append('+');
                tv.setText(viewsb.toString());
                calcsb.delete(0,calcsb.length());
                break;
            case R.id.minus :
                operator = 2;
                if(onetime==true) {
                    calcvalues[0] = calcvalues[1];
                    onetime = false;
                }
                viewsb.append('-');
                tv.setText(viewsb.toString());
                calcsb.delete(0,calcsb.length());
                break;
            case R.id.multi :
                operator = 3;
                if(onetime==true) {
                    calcvalues[0] = calcvalues[1];
                    onetime = false;
                }
                viewsb.append('*');
                tv.setText(viewsb.toString());
                calcsb.delete(0,calcsb.length());
                break;
            case R.id.divi :
                operator = 4;
                if(onetime==true) {
                    calcvalues[0] = calcvalues[1];
                    onetime = false;
                }
                viewsb.append('/');
                tv.setText(viewsb.toString());
                calcsb.delete(0,calcsb.length());
                break;
            case R.id.equal :
                equaled = true;
                tv.setText(Integer.toString(calc(operator)));
                viewsb.delete(0,viewsb.length());
                viewsb.append(calcvalues[0]);
                break;
            case R.id.clear :
                viewsb.delete(0,viewsb.length());
                calcsb.delete(0,calcsb.length());
                calcvalues[0] = 0;
                calcvalues[1] = 0;
                tv.setText(null);
                onetime = true;
                break;
        }
        testtv.setText("[0]:"+calcvalues[0]+" [1]:"+calcvalues[1]);//テスト用
    }
    private int calc(int i){
        switch (i){
            case 1 :
                calcvalues[0] = calcvalues[0] + calcvalues[1];
                break;
            case 2 :
                calcvalues[0] = calcvalues[0] - calcvalues[1];
                break;
            case 3 :
                calcvalues[0] = calcvalues[0] * calcvalues[1];
                break;
            case 4 :
                calcvalues[0] = calcvalues[0] / calcvalues[1];
                break;
        }
        return calcvalues[0];
    }
}
