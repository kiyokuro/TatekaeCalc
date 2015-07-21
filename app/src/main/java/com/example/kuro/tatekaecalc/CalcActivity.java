package com.example.kuro.tatekaecalc;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by keinon on 2015/07/04.
 */

public class CalcActivity extends Activity{
    private StringBuilder viewsb = new StringBuilder();//表示用
    private StringBuilder calcsb = new StringBuilder();//計算用int operator = 0;//演算子を保存
    private Double[] calcvalues = new Double[2];
    boolean is_numcopy = true;
    boolean equal_subsequent = false;
    boolean dot_exist  = false;
    private int operator =  0;
    public void calc(View view,TextView tv,TextView testtv){

        if(viewsb.length()>=13 && view.getId()!=R.id.clear){
            if(viewsb.length()>=13 && view.getId()!=R.id.back){
                return;
            }
        }
        switch(view.getId()){
            case R.id.number0 :
                if(equal_subsequent == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    is_numcopy = true;
                    equal_subsequent = false;
                }
                if(viewsb.length()==0)
                    break;
                calcsb.append(0);
                viewsb.append(0);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number1 :
                if(equal_subsequent == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    is_numcopy = true;
                    equal_subsequent = false;
                }
                viewsb.append(1);
                calcsb.append(1);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number2 :
                if(equal_subsequent == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    is_numcopy = true;
                    equal_subsequent = false;
                }
                viewsb.append(2);
                calcsb.append(2);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number3 :
                if(equal_subsequent == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    is_numcopy = true;
                    equal_subsequent = false;
                }
                viewsb.append(3);
                calcsb.append(3);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number4 :
                if(equal_subsequent == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    is_numcopy = true;
                    equal_subsequent = false;
                }
                viewsb.append(4);
                calcsb.append(4);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number5 :
                if(equal_subsequent == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    is_numcopy = true;
                    equal_subsequent = false;
                }
                viewsb.append(5);
                calcsb.append(5);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number6 :
                if(equal_subsequent == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    is_numcopy = true;
                    equal_subsequent = false;
                }
                viewsb.append(6);
                calcsb.append(6);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number7 :
                if(equal_subsequent == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    is_numcopy = true;
                    equal_subsequent = false;
                }
                viewsb.append(7);
                calcsb.append(7);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number8 :
                if(equal_subsequent == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    is_numcopy = true;
                    equal_subsequent = false;
                }
                viewsb.append(8);
                calcsb.append(8);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.number9 :
                if(equal_subsequent == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    is_numcopy = true;
                    equal_subsequent = false;
                }
                viewsb.append(9);
                calcsb.append(9);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.dot :
                //項の初めにドットが入力されたら頭に0をつける
                if(viewsb.length()==0 || viewsb.indexOf("+",viewsb.length()-1)==1){
                    viewsb.append(0);
                    calcsb.append(0);
                }
                //各項の中にドットが2つ以上入らないようにする
                if(viewsb.indexOf(".")!=-1) {//ドットがあればtrue
                    if ((viewsb.indexOf("+") == -1 && viewsb.indexOf("-") == -1 && viewsb.indexOf("*") == -1 && viewsb.indexOf("/") == -1)) {//演算子がなければtrue
                        break;
                    }else  if(viewsb.indexOf(".",viewsb.indexOf("+"))==-1 && viewsb.indexOf(".",viewsb.indexOf("-"))==-1 && viewsb.indexOf(".",viewsb.indexOf("*"))==-1 && viewsb.indexOf(".",viewsb.indexOf("/"))==-1) {//演算子より後ろにドットがあればtrue
                        break;
                    }
                }
                if(equal_subsequent == true){
                    viewsb.delete(0,viewsb.length());
                    calcsb.delete(0,calcsb.length());
                    is_numcopy = true;
                    equal_subsequent = false;
                }
                viewsb.append('.');
                calcsb.append('.');
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                break;
            case R.id.plus :
                operator = 1;
                if(is_numcopy==true) {
                    calcvalues[0] = calcvalues[1];
                    is_numcopy = false;
                }
                viewsb.append('+');
                tv.setText(viewsb.toString());
                calcsb.delete(0,calcsb.length());
                break;
            case R.id.minus :
                operator = 2;
                if(is_numcopy==true) {
                    calcvalues[0] = calcvalues[1];
                    is_numcopy = false;
                }
                viewsb.append('-');
                tv.setText(viewsb.toString());
                calcsb.delete(0,calcsb.length());
                break;
            case R.id.multi :
                operator = 3;
                if(is_numcopy==true) {
                    calcvalues[0] = calcvalues[1];
                    is_numcopy = false;
                }
                viewsb.append('*');
                tv.setText(viewsb.toString());
                calcsb.delete(0,calcsb.length());
                break;
            case R.id.divi :
                operator = 4;
                if(is_numcopy==true) {
                    calcvalues[0] = calcvalues[1];
                    is_numcopy = false;
                }
                viewsb.append('/');
                tv.setText(viewsb.toString());
                calcsb.delete(0,calcsb.length());
                break;
            case R.id.equal :
                equal_subsequent = true;
                tv.setText(Double.toString(calc(operator)));
                viewsb.delete(0,viewsb.length());
                viewsb.append(calcvalues[0]);
                break;
            case R.id.clear :
                viewsb.delete(0,viewsb.length());
                calcsb.delete(0,calcsb.length());
                calcvalues[0] = 0.0;
                calcvalues[1] = 0.0;
                tv.setText(null);
                is_numcopy = true;
                break;
            case R.id.back :
                if(viewsb.length()==0)
                    break;
                viewsb.delete(viewsb.length()-1,viewsb.length());
                calcsb.delete(calcsb.length()-1,calcsb.length());
                if(calcsb.toString().equals("")) {
                    calcvalues[1] = 0.0;
                }else{
                    calcvalues[1] = Double.parseDouble(calcsb.toString());
                }
                tv.setText(viewsb.toString());
                break;
        }
        testtv.setText("[0]:"+calcvalues[0]+" [1]:"+calcvalues[1]);//テスト用
    }
    private double calc(int i){
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
