package com.example.kuro.tatekaecalc;

import android.app.Activity;
import android.view.View;
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

    private StringBuilder viewsb = new StringBuilder();//�\���p
    private StringBuilder calcsb = new StringBuilder();//�v�Z�pint operator = 0;//���Z�q��ۑ�
    private Double[] calcvalues = new Double[2];
    private boolean is_numcopy = true;
    private boolean equal_subsequent = false;//�C�R�[���������ꂽ�ォ
    private boolean dot_exist  = false;
    private int operator =  0;//���Z�q�������œ���1=+,2=-,3=*,4=/
    private boolean after_operator = true;//���Z�q�����͂��ꂽ�B�e���̏��߂ɉ��Z�q�ƃh�b�g������Ȃ��悤�ɂ��邽�߁A�����l��true�ɂ���
    private boolean after_operator2 = false;
    private boolean after_dot = false;//�����_�����͂��ꂽ�ォ

    public void calc(View view,TextView tv,TextView testtv){
        /*��ʂ̐�������͂���G���A�̃T�C�Y��13�����ȏ�͌����Ȃ��Ȃ邽�ߓ��͂����Ȃ�*/
        if(viewsb.length()>=13 && view.getId()!=R.id.clear){
            if(viewsb.length()>=13 && view.getId()!=R.id.back){
                return;
            }
        }
        switch(view.getId()){
            /*0�̏���*/
            case R.id.number0 :
                newInsert();
                if(after_operator==true)
                    break;
                calcsb.append(0);
                viewsb.append(0);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                after_operator = false;
                break;
            /*1�̏���*/
            case R.id.number1 :
                newInsert();
                calcsb.append(1);
                viewsb.append(1);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                after_operator = false;
                break;
            /*2�̏���*/
            case R.id.number2 :
                newInsert();
                calcsb.append(2);
                viewsb.append(2);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                after_operator = false;
                break;
            /*3�̏���*/
            case R.id.number3 :
                newInsert();
                calcsb.append(3);
                viewsb.append(3);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                after_operator = false;
                break;
            /*4�̏���*/
            case R.id.number4 :
                newInsert();
                calcsb.append(4);
                viewsb.append(4);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                after_operator = false;
                break;
            /*5�̏���*/
            case R.id.number5 :
                newInsert();
                calcsb.append(5);
                viewsb.append(5);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                after_operator = false;
                break;
            /*6�̏���*/
            case R.id.number6 :
                calcsb.append(6);
                viewsb.append(6);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                after_operator = false;
                break;
            /*7�̏���*/
            case R.id.number7 :
                newInsert();
                calcsb.append(7);
                viewsb.append(7);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                after_operator = false;
                break;
            /*8�̏���*/
            case R.id.number8 :
                newInsert();
                calcsb.append(8);
                viewsb.append(8);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                after_operator = false;
                break;
            /*9�̏���*/
            case R.id.number9 :
                newInsert();
                calcsb.append(9);
                viewsb.append(9);
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                after_operator = false;
                break;
            /*.�̏���*/
            case R.id.dot :
                //���̏��߂Ƀh�b�g�����͂��ꂽ�瓪��0������
                if(after_operator==true){
                    viewsb.append(0);
                    calcsb.append(0);
                    after_operator = false;
                }
                /*�e���̒��Ƀh�b�g��2�ȏ����Ȃ��悤�ɂ���*/
                if(after_dot == true){
                    break;
                }
                viewsb.append('.');
                calcsb.append('.');
                calcvalues[1] = Double.parseDouble(calcsb.toString());
                tv.setText(viewsb.toString());
                after_dot = true;
                break;
            /*�{�̏���*/
            case R.id.plus :
                if(after_operator == true) {
                    break;
                }
                if(after_operator2 == true){
                    calcvalues[0] = calc(operator);
                    viewsb.delete(0, viewsb.length());
                    calcsb.delete(0, calcsb.length());
                    viewsb.append(calcvalues[0]);
                    calcsb.append(calcvalues[0]);
                }
                operator = 1;
                if(is_numcopy==true) {
                    calcvalues[0] = calcvalues[1];
                    is_numcopy = false;
                }
                viewsb.append('+');
                tv.setText(viewsb.toString());
                calcsb.delete(0, calcsb.length());
                after_dot = false;
                equal_subsequent = false;
                after_operator = true;
                after_operator2 = true;
                break;
            /*�|�̏���*/
            case R.id.minus :
                if(after_operator == true) {
                    break;
                }
                if(after_operator2 == true){
                    calcvalues[0] = calc(operator);
                    viewsb.delete(0, viewsb.length());
                    calcsb.delete(0, calcsb.length());
                    viewsb.append(calcvalues[0]);
                    calcsb.append(calcvalues[0]);
                }
                operator = 2;
                if(is_numcopy==true) {
                    calcvalues[0] = calcvalues[1];
                    is_numcopy = false;
                }
                viewsb.append('-');
                tv.setText(viewsb.toString());
                calcsb.delete(0, calcsb.length());
                after_dot = false;
                equal_subsequent = false;
                after_operator = true;
                after_operator2 = true;
                break;
            /*�~�̏���*/
            case R.id.multi :
                if(after_operator == true) {
                    break;
                }
                if(after_operator2 == true){
                    calcvalues[0] = calc(operator);
                    viewsb.delete(0, viewsb.length());
                    calcsb.delete(0, calcsb.length());
                    viewsb.append(calcvalues[0]);
                    calcsb.append(calcvalues[0]);
                }
                operator = 3;
                if(is_numcopy==true) {
                    calcvalues[0] = calcvalues[1];
                    is_numcopy = false;
                }
                viewsb.append('*');
                tv.setText(viewsb.toString());
                calcsb.delete(0, calcsb.length());
                after_dot = false;
                equal_subsequent = false;
                after_operator = true;
                after_operator2 = true;
                break;
            /*���̏���*/
            case R.id.divi :
                if(after_operator == true) {
                    break;
                }
                if(after_operator2 == true){
                    calcvalues[0] = calc(operator);
                    viewsb.delete(0, viewsb.length());
                    calcsb.delete(0, calcsb.length());
                    viewsb.append(calcvalues[0]);
                    calcsb.append(calcvalues[0]);
                }
                operator = 4;
                if(is_numcopy==true) {
                    calcvalues[0] = calcvalues[1];
                    is_numcopy = false;
                }
                viewsb.append('/');
                tv.setText(viewsb.toString());
                calcsb.delete(0, calcsb.length());
                after_dot = false;
                equal_subsequent = false;
                after_operator = true;
                after_operator2 = true;
                break;
            /*���̏���*/
            case R.id.equal :
                equal_subsequent = true;
                tv.setText(Double.toString(calc(operator)));
                viewsb.delete(0, viewsb.length());
                viewsb.append(calcvalues[0]);
                calcsb.append(calcvalues[0]);
                after_dot = false;
                after_operator2 = false;
                break;
            /*CRL�̏���*/
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
            /*1���������{�^���̏���*/
            case R.id.back :
                if(viewsb.length()==0)
                    break;
                /*1���������Ă��ꂪ�h�b�g�Ȃ�after_dot��false�ɖ߂�*/
                if(viewsb.indexOf(".",viewsb.length()-1)==1)
                    after_dot = false;

                /*calcsb�ɂ͉��Z�q�������Ă��Ȃ����ߏ�����ς���B*/
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
        testtv.setText("[0]:"+calcvalues[0]+" [1]:"+calcvalues[1]);//�e�X�g�p
    }
    /*�C�R�[���������ꂽ���̌v�Z*/
    private double calc(int i){
        switch (i){
            case 0 ://���Z�q�������ĂȂ���ԂŃC�R�[���������ꂽ��Ȃɂ����Ȃ��B
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
    private void inputNum(TextView tv, double num, StringBuilder calcsb){
        calcsb.append(num);
        viewsb.append(num);
        calcvalues[1] = Double.parseDouble(calcsb.toString());
        tv.setText(viewsb.toString());
        after_operator = false;
    }
}
