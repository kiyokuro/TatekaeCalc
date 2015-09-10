package com.example.kuro.tatekaecalc;

import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by kiyokuro on 2015/07/04.
 */

public class Calc extends Activity{
    public String getViewsb(){
        return String.valueOf(viewsb);
    }
    public boolean getAfterOperator(){return after_operator;}
    public void setViewsb(String str){
        viewsb.append(str);
        calcsb.append(str);
    }
    public void updateView(View view,TextView tv){
        calcvalues[1] = Double.parseDouble(calcsb.toString());
        tv.setText(viewsb.toString());
        after_operator = false;
    }

    private StringBuilder viewsb = new StringBuilder();//表示用
    private StringBuilder calcsb = new StringBuilder();//計算用int operator = 0;//演算子を保存
    private Double[] calcvalues = new Double[2];
    private boolean is_numcopy = true;
    private boolean equal_subsequent = false;//イコールが押された後か
    private boolean dot_exist  = false;
    private int operator =  0;//演算子が数字で入る1=+,2=-,3=*,4=/
    private boolean after_operator = true;//演算子が入力された。各項の初めに演算子とドットが入らないようにするため、初期値はtrueにする
    private boolean after_operator2 = false;
    private boolean after_dot = false;//小数点が入力された後か

    public void calc(View view,TextView tv,TextView logtv,ArrayAdapter<String> adapter2,ListView listView2){
        /*画面の数字を入力するエリアのサイズ上13文字以上は見えなくなるため入力させない*/
        if(viewsb.length()>=16 && view.getId()!=R.id.clear){
            if(viewsb.length()>=16 && view.getId()!=R.id.back){
                return;
            }
        }
        switch(view.getId()){
            /*0の処理*/
            case R.id.number0 :
                newInsert();
                if(after_operator==true)
                    break;
                appendNum(0,tv);
                break;
            /*1の処理*/
            case R.id.number1 :
                newInsert();
                appendNum(1,tv);
                break;
            /*2の処理*/
            case R.id.number2 :
                newInsert();
                appendNum(2,tv);
                break;
            /*3の処理*/
            case R.id.number3 :
                newInsert();
                appendNum(3,tv);
                break;
            /*4の処理*/
            case R.id.number4 :
                newInsert();
                appendNum(4,tv);
                break;
            /*5の処理*/
            case R.id.number5 :
                newInsert();
                appendNum(5,tv);
                break;
            /*6の処理*/
            case R.id.number6 :
                appendNum(6,tv);
                break;
            /*7の処理*/
            case R.id.number7 :
                newInsert();
                appendNum(7,tv);
                break;
            /*8の処理*/
            case R.id.number8 :
                newInsert();
                appendNum(8,tv);
                break;
            /*9の処理*/
            case R.id.number9 :
                newInsert();
                appendNum(9,tv);
                break;
            /*.の処理*/
            case R.id.dot :
                //項の初めにドットが入力されたら頭に0をつける
                if(after_operator==true){
                    viewsb.append(0);
                    calcsb.append(0);
                    after_operator = false;
                }
                /*各項の中にドットが2つ以上入らないようにする*/
                if(after_dot == true){
                    break;
                }
                viewsb.append('.');
                calcsb.append('.');
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                after_dot = true;
                break;
            /*＋の処理*/
            case R.id.plus :
                if(after_operator == true) {
                    break;
                }
                appendOperator(1, "+", tv, logtv,adapter2,listView2);
                break;
            /*－の処理*/
            case R.id.minus :
                if(after_operator == true) {
                    break;
                }
                appendOperator(2, "-", tv, logtv,adapter2,listView2);
                break;
            /*×の処理*/
            case R.id.multi :
                if(after_operator == true) {
                    break;
                }
                appendOperator(3, "*", tv, logtv,adapter2,listView2);
                break;
            /*÷の処理*/
            case R.id.divi :
                if(after_operator == true) {
                    break;
                }
                appendOperator(4, "/", tv, logtv,adapter2,listView2);
                break;
            /*＝の処理*/
            case R.id.equal :
                equal_subsequent = true;
                tv.setText(Double.toString(calc(operator,logtv,viewsb,adapter2,listView2)));
                viewsb.delete(0, viewsb.length());
                viewsb.append(calcvalues[0]);
                calcsb.append(calcvalues[0]);
                after_dot = false;
                after_operator2 = false;
                break;
            /*CRLの処理*/
            case R.id.clear :
                viewsb.delete(0,viewsb.length());
                calcsb.delete(0, calcsb.length());
                calcvalues[0] = 0.0;
                calcvalues[1] = 0.0;
                tv.setText(null);
                operator=0;
                is_numcopy = true;
                after_dot = false;
                after_operator = true;
                after_operator2 = false;
                break;
            /*1文字消すボタンの処理*/
            case R.id.back :
                if(viewsb.length()==0)
                    break;
                /*1文字消してそれがドットならafter_dotをfalseに戻す*/
                if(viewsb.indexOf(".",viewsb.length()-1)==1)
                    after_dot = false;

                /*calcsbには演算子が入っていないため処理を変える。*/
                if(viewsb.indexOf("+") == viewsb.length()-1 || viewsb.indexOf("-") == viewsb.length()-1 ||viewsb.indexOf("*") == viewsb.length()-1 || viewsb.indexOf("/") == viewsb.length()-1){
                    operator=0;
                    calcvalues[1]=calcvalues[0];
                    calcsb.append(calcvalues[1]);
                    calcvalues[0]=0.0;
                    after_operator = false;
                    after_operator2 = false;
                }else {
                    calcsb.delete(calcsb.length() - 1, calcsb.length());
                }

                viewsb.delete(viewsb.length()-1,viewsb.length());

                if(calcsb.toString().equals("")) {
                    after_operator = true;
                    calcvalues[1] = 0.0;
                }else if(equal_subsequent==true) {
                    newInsert();
                }else{
                    calcvalues[1] = Double.parseDouble(calcsb.toString());
                }
                tv.setText(viewsb.toString());
                break;
        }
        //logtv.setText("[0]:" + calcvalues[0] + " [1]:" + calcvalues[1]);//テスト用
    }

    /*StringBuilderに数字を追加*/
    private  void appendNum(int num,TextView tv) {
        calcsb.append(num);
        viewsb.append(num);
        calcvalues[1] = Double.parseDouble(calcsb.toString());
        tv.setText(viewsb.toString());
        after_operator = false;
    }
    /*StringBuilderに演算子を追加*/
    private void appendOperator(int operator,String strOp, TextView tv, TextView logtv,ArrayAdapter<String> adapter2,ListView listView2){
        if(after_operator2 == true){
            calcvalues[0] = calc(operator,logtv,viewsb,adapter2,listView2);
            viewsb.delete(0, viewsb.length());
            calcsb.delete(0, calcsb.length());
            viewsb.append(calcvalues[0]);
            calcsb.append(calcvalues[0]);
        }
        this.operator = operator;
        if(is_numcopy==true) {
            calcvalues[0] = calcvalues[1];
            is_numcopy = false;
        }
        viewsb.append(strOp);
        tv.setText(viewsb.toString());
        calcsb.delete(0, calcsb.length());
        after_dot = false;
        equal_subsequent = false;
        after_operator = true;
        after_operator2 = true;
    }
    /*イコールが押された時の計算*/
    private double calc(int i, TextView textView,StringBuilder viewsb,ArrayAdapter<String> adapter2,ListView listView2){
        textView.setText(String.valueOf(viewsb));
        listView2.setAdapter(adapter2);
        // 要素を一番上に追加
        adapter2.insert(String.valueOf(viewsb), 0);
        switch (i){
            case 0 ://演算子が入ってない状態でイコールが押されたらなにもしない。
                break;
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

    private void newInsert(){
        if(equal_subsequent == true){
            viewsb.delete(0,viewsb.length());
            calcsb.delete(0,calcsb.length());
            calcvalues[0]=0.0;
            calcvalues[1]=0.0;
            is_numcopy = true;
            equal_subsequent = false;
        }
    }
}
