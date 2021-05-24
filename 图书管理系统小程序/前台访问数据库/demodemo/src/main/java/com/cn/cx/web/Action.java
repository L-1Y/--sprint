package com.cn.cx.web;
import com.cn.cx.util.bean.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
// spring framework
@RestController
@RequestMapping("login")
public class Action {
    @GetMapping("allInfo")
    public ArrayList<BookInfo> bookInfo()
    {
        return  com.cn.cx.util.Dao.searchbook();
    };
    //小程序好书分享板块-----查找好书的全部内容
    @GetMapping("goodbook")
    public ArrayList<GoodBook> goodbook()
    {
        return  com.cn.cx.util.Dao. searchgoodbook();
    };
    //扫一扫功能----根据xuhao 查出书的全部内容
    @GetMapping("saoyisao")
    public  ArrayList<BookInfo> sao(@RequestParam String xuhao)
    {
        return  com.cn.cx.util.Dao.saoyisao(xuhao);
    };
     //搜索对应书籍的信息——计算机、数学、中文、外语、护理、体育、经济
    @GetMapping("booktype")
    public  ArrayList<BookInfo> booktype(@RequestParam String leixing)
    {
        return  com.cn.cx.util.Dao.booktype(leixing);
    };
    //插入到借阅表中
    @GetMapping("insertjieyue")
    public  void insertjieyue(@RequestParam String xuhao,@RequestParam String number)
    {
      com.cn.cx.util.Dao.insertjieyue(xuhao,number);
    };
    //实现还书
    @GetMapping("huanshu")
    public  void huanshu(@RequestParam String xuhao,@RequestParam String number)
    {
        com.cn.cx.util.Dao.huanshu(xuhao,number);
    };
    //搜索对应书的具体内容
    @GetMapping("book_content")
    public   ArrayList<book_content>showcontent(@RequestParam int xuhao,@RequestParam String number)
    {
       return  com.cn.cx.util.Dao.bookcontent(xuhao,number);
    };
    //显示借阅查询板块
    @GetMapping("jieyue")
    public   ArrayList<ShowJIe>jieyue(@RequestParam String number)
    {
        return  com.cn.cx.util.Dao.jieyue(number);
    };
    //收藏板块，sc加一操作
    @GetMapping("shoucang")
    public  void shoucang(@RequestParam String  number,@RequestParam String xuhao)
    {
        com.cn.cx.util.Dao.shoucang(number,xuhao);
    };
    //取消收藏板块，sc减一操作
   @GetMapping("quxiaoshoucang")
    public  void quxiaoshoucang(@RequestParam String number,@RequestParam String xuhao)
    {
        com.cn.cx.util.Dao.quxiaoshoucang(number,xuhao);
    };
    //好书分享板块-----取出收藏的前五本数据
    @GetMapping("good_book")
    public ArrayList<Good_book> good_book()
    {
        return com.cn.cx.util.Dao.good_kook();
    };
    //登录操作，学生信息插入
    @GetMapping("insert_student")
    public void insertStudent(@RequestParam String number,@RequestParam String name,@RequestParam String phone,@RequestParam String fyzy)
    {
         com.cn.cx.util.Dao.insertStudent(number,name,phone,fyzy);
    };
    //小程序首页index 猜你喜欢板块
    @GetMapping("lovebook")
    public  ArrayList<BookInfo>  lovebook()
    {
        return  com.cn.cx.util.Dao.lovebook();
    };
    //
    //小程序首页index 猜你喜欢板块
    @GetMapping("updatephone")
    public void  updaphone(@RequestParam String  number,@RequestParam String phone)
    {
         com.cn.cx.util.Dao.updatephone(number,phone);
    };
    //收藏的书
    @GetMapping("shoucang_book")
    public ArrayList<Shoucang_book>  shoucang_book(@RequestParam String  number)
    {
       return com.cn.cx.util.Dao.shoucang_book(number);
    }
}
