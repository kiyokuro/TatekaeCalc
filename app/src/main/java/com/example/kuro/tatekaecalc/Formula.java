package com.example.kuro.tatekaecalc;

/**
 * Created by keinon on 2015/08/18.
 */
public class Formula {
    int id;
    String formula = "";

    public void setFormula(String num){
        this.formula = num;
    }

    public String getFormula() {
        return formula;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
}
