package com.cn.cx.util.bean;
public class book_content {
    private int xuhao;
    private String content;
    private String bookname;
    private  String image;
     private int yuliang;
     private  String leixing;
     boolean  flag;

    public int getXuhao() {
        return xuhao;
    }

    public void setXuhao(int xuhao) {
        this.xuhao = xuhao;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setYuliang(int yuliang) {
        this.yuliang = yuliang;
    }

    public int getYuliang() {
        return yuliang;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }

    public String getLeixing() {
        return leixing;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
