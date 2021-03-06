package com.example.kuro.tatekaecalc;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import jp.gr.java_conf.kzstudio.tatekaecalc.R;
import jp.hishidama.eval.ExpRuleFactory;
import jp.hishidama.eval.Expression;
import jp.hishidama.eval.Rule;

/**
 * Created by kiyokuro on 2015/07/04.
 */

class Calc extends Activity{
    public String getFormula(){return String.valueOf(formula);}
    public void setFormula(String str){formula.append(str);}
    public void updateView(View view,TextView tv){
        tv.setText(formula.toString());
        if(formula.indexOf("+",formula.length()-1)==-1 && formula.indexOf("-",formula.length()-1)==-1 && formula.indexOf("*",formula.length()-1)==-1 && formula.indexOf("/",formula.length()-1)==-1) {
            after_operator = false;
        }else{
            after_operator = true;
        }
    }

    private StringBuilder formula = new StringBuilder();
    private Double[] calcvalues = new Double[2];
    private boolean is_numcopy = true;
    private boolean equal_subsequent = false;//イコールが押された後か
    private int operator =  0;//演算子が数字で入る1=+,2=-,3=*,4=/
    private boolean after_operator = true;//演算子が入力された。各項の初めに演算子とドットが入らないようにするため、初期値はtrueにする
    private boolean after_operator2 = true;
    private boolean after_dot = false;//小数点が入力された後か
    private boolean isMinus = false;//演算子と別に－があるか

    public void calc(View view,TextView tv,ArrayAdapter<String> adapter2,ListView listView2){
        /*画面の数字を入力するエリアのサイズ上13文字以上は見えなくなるため入力させない*/
        if(formula.length()>=19 && view.getId()!= R.id.clear){
            if(formula.length()>=19 && view.getId()!=R.id.back){
                if(formula.length()>=19 && view.getId()!=R.id.equal) {
                    return;
                }
            }
        }
        /*Infinityが表示されていたら消す*/
        if(formula.lastIndexOf("y")==formula.length()-1){
            formula.delete(0,formula.length());
            tv.setText(formula.toString());
        }
        switch(view.getId()){
            /*0の処理*/
            case R.id.number0 :
                newInsert();
                //if(after_operator==true)
                //    break;
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
                if(formula.indexOf(".",formula.length()-1)==-1 && after_dot == false){
                    //項の初めにドットが入力されたら頭に0をつける
                    if (after_operator == true) {
                        formula.append(0);
                        after_operator = false;
                    }
                /*各項の中にドットが2つ以上入らないようにする*/
                    //if (after_dot == true) {
                        //break;
                    //}
                    formula.append('.');
                    after_dot = true;
                    tv.setText(formula.toString());
                }
                break;
            /*＋の処理*/
            case R.id.plus :
                if(after_operator == true) {
                    break;
                }
                appendOperator(1, "+", tv, adapter2,listView2);
                break;
            /*－の処理*/
            case R.id.minus :
                if (formula.length() == 0) {
                    formula.append("-");
                } else if (formula.lastIndexOf("+") == formula.length() - 1 || formula.lastIndexOf("*") == formula.length() - 1 || formula.lastIndexOf("/") == formula.length() - 1) {
                    formula.append("-");
                    if (formula.lastIndexOf("-") == formula.length() - 1) {
                        if(formula.lastIndexOf("+") == formula.length() - 1 || formula.lastIndexOf("*") == formula.length() - 1 || formula.lastIndexOf("/") == formula.length() - 1){
                            formula.delete(formula.length() - 1, formula.length());
                        }else {
                            //Log.v("formula★", String.valueOf(formula.lastIndexOf("-")));

                        }
                    } else {

                    }
                }else if(formula.lastIndexOf("-") == formula.length() - 1){
                    if(formula.lastIndexOf("+") == formula.length() - 2 || formula.lastIndexOf("*") == formula.length() - 2 || formula.lastIndexOf("/") == formula.length() - 2) {

                    }else{
                        formula.delete(formula.length() - 1, formula.length());
                        formula.append("+");
                    }
                }

                tv.setText(formula.toString());
                if(after_operator == true) {
                    break;
                }
                appendOperator(2, "-", tv, adapter2,listView2);
                break;
            /*×の処理*/
            case R.id.multi :
                if(after_operator == true) {
                    break;
                }
                appendOperator(3, "*", tv, adapter2,listView2);
                break;
            /*÷の処理*/
            case R.id.divi :
                if(after_operator == true) {
                    break;
                }
                appendOperator(4, "/", tv, adapter2,listView2);
                break;
            /*＝の処理*/
            case R.id.equal :
                if(formula.lastIndexOf("+")==formula.length()-1 || formula.lastIndexOf("-")==formula.length()-1 || formula.lastIndexOf("*")==formula.length()-1 || formula.lastIndexOf("/")==formula.length()-1){
                    break;
                }
                equal_subsequent = true;
                tv.setText(calc(operator, formula, adapter2, listView2));
                after_dot = true;
                after_operator2 = true;
                break;
            /*+/-の処理*/
            case R.id.swich :
                boolean mui=false;//－符号の有無
                //if(mui==false) {
                //    formula.append("-");
                //}else {

                //}
                break;
            /*CRLの処理*/
            case R.id.clear :
                formula.delete(0,formula.length());
                tv.setText(null);
                operator=0;
                is_numcopy = true;
                after_dot = false;
                after_operator = true;
                after_operator2 = true;
                break;
            /*1文字消すボタンの処理*/
            case R.id.back :
                if(formula.length()==0) {
                    break;
                }
                if (formula.lastIndexOf("+") == formula.length() - 1 || formula.lastIndexOf("-") == formula.length() - 1 ||
                        formula.lastIndexOf("*") == formula.length() - 1 || formula.lastIndexOf("/") == formula.length() - 1) {
                    after_operator=false;
                }
                /*1文字消してそれがドットならafter_dotをfalseに戻す*/
                if(formula.lastIndexOf(".")==formula.length()-1) {
                    after_dot = false;
                }
                Log.v("★", String.valueOf(after_operator));
                formula.delete(formula.length()-1,formula.length());
                tv.setText(formula.toString());
                break;
        }
        //logtv.setText("[0]:" + calcvalues[0] + " [1]:" + calcvalues[1]);//テスト用
    }

    /*StringBuilderに数字を追加*/
    private  void appendNum(int num,TextView tv) {
        formula.append(num);
        tv.setText(formula.toString());
        after_operator = false;
    }
    /*StringBuilderに演算子を追加*/
    private void appendOperator(int operator,String strOp, TextView tv, ArrayAdapter<String> adapter2,ListView listView2){
        if(formula.indexOf("+",formula.length()-1)==-1 && formula.indexOf("-",formula.length() - 1) == -1 && formula.indexOf("*",formula.length()-1)==-1 && formula.indexOf("/",formula.length()-1)==-1) {
            this.operator = operator;
            formula.append(strOp);
            tv.setText(formula.toString());
            after_dot = false;
            equal_subsequent = false;
            after_operator = true;
            after_operator2 = true;
        }else{
            return;
        }
    }

    /*イコールが押された時の計算*/
    private String calc(int i, StringBuilder formula,ArrayAdapter<String> adapter2,ListView listView2){
        //textView.setText(String.valueOf(formula));
        listView2.setAdapter(adapter2);
        // 要素を一番上に追加
        adapter2.insert(String.valueOf(formula), 0);
        //ログの要素の数が20を超えたら古い要素から消していく
        if(listView2.getCount() > 20){
            adapter2.remove(adapter2.getItem(20));
        }
        double result=0.0;
        try {
            Rule rule = ExpRuleFactory.getDefaultRule();
            Expression exp = rule.parse(String.valueOf(formula));//解析
            result = exp.evalDouble(); //計算実施
        }catch (Exception e){
            formula.delete(0, formula.length());
            return "エラー";
        }

        formula.delete(0, formula.length());
        //formula.append(result);

        StringBuilder temp = new StringBuilder();
        temp.append(result);
        if(formula.lastIndexOf("0")==formula.length()-1 && formula.lastIndexOf(".")==formula.length()-2){
            formula.delete(formula.length()-2,formula.length());
            temp.delete(temp.length()-2,temp.length());
        }
        if(temp.length()>21){
            temp.delete(21,temp.length());
        }
        if(temp.indexOf(".")!=-1 && temp.indexOf("E")==-1){
            while(temp.lastIndexOf("0")==temp.length()-1){
                temp.delete(temp.length()-1,temp.length());
            }
            if(temp.lastIndexOf(".")==temp.length()-1){
                temp.delete(temp.length()-1,temp.length());
            }

        }
        String fixResult = String.valueOf(temp);
        formula.append(temp);
        return fixResult;
    }

    private void newInsert(){
        if(equal_subsequent == true){
            formula.delete(0,formula.length());
            calcvalues[0]=0.0;
            calcvalues[1]=0.0;
            is_numcopy = true;
            equal_subsequent = false;
            after_dot = false;
        }
    }
}
