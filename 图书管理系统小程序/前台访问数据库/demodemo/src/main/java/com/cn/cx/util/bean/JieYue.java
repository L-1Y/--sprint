package com.cn.cx.util.bean;
import java.util.Date;
public class JieYue {
    private  int id;
    private int xuhao;
    private String number;
    private Date time;
    private int sc;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setXuhao(int xuhao) {
        this.xuhao = xuhao;
    }

    public int getXuhao() {
        return xuhao;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }

    public int getSc() {
        return sc;
    }
}
