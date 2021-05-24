package com.cn.cx.util.bean;

public class Shoucang_book {
    private   int xuhao;
    private  String content;
    private String  bookname;
    private String image;
    boolean  flag;

    public void setXuhao(int xuhao) {
        this.xuhao = xuhao;
    }

    public int getXuhao() {
        return xuhao;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookname() {
        return bookname;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
