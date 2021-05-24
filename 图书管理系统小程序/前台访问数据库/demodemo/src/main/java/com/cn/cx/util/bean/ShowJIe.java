package com.cn.cx.util.bean;
import java.util.Date;
public class ShowJIe {
    private  String xuhao;
    private  String bookname;
    private Date time;
    private String number;
    private  String name;
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookname() {
        return bookname;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setXuhao(String xuhao) {
        this.xuhao = xuhao;
    }

    public String getXuhao() {
        return xuhao;
    }
}
