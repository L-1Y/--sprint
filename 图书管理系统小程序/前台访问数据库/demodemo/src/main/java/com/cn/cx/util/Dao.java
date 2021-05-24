package com.cn.cx.util;
import com.cn.cx.util.bean.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Dao {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8";
    static final String USER = "root";
    static final String PASS = "root";
    //搜索书的全部信息-----小程序首页全部书籍
    public static ArrayList<BookInfo> searchbook() {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<BookInfo> rst = new ArrayList<BookInfo>();
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("allInfo:正在连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer("select  book.xuhao,bookname,zongliang,yuliang,sj_number,leixing,image FROM book,book_image where book.xuhao=book_image.xuhao");
            ResultSet rs = stmt.executeQuery(sql.toString());
            while (rs.next()) {
                BookInfo dto = new BookInfo();
                dto.setXuhao(rs.getInt("xuhao"));
                dto.setBookname(rs.getString("bookname"));
                dto.setZongliang(rs.getInt("zongliang"));
                dto.setYuliang(rs.getInt("yuliang"));
                dto.setSj_number(rs.getString("sj_number"));
                dto.setLeixing(rs.getString("leixing"));
                dto.setImage(rs.getString("image"));
                rst.add(dto);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("      allInfo:连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return rst;
    }
    //搜索好书信息-----对应小程序活动板块
    public static ArrayList<GoodBook> searchgoodbook() {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<GoodBook> rst = new ArrayList<GoodBook>();
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("goodbook:连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer("select  * FROM  good_book");
            ResultSet rs = stmt.executeQuery(sql.toString());
            while (rs.next()) {
                GoodBook dto = new GoodBook();
                dto.setId(rs.getInt("id"));
                dto.setTitle(rs.getString("title"));
                dto.setUser_id(rs.getString("user_id"));
                dto.setUser_content(rs.getString("user_content"));
                dto.setTime(rs.getString("time"));
                dto.setImage(rs.getString("image"));
                rst.add(dto);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("      goodbook:连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return rst;
    }
    //二维码借书功能-----插入数据表book中
    public void insertbook(String xuhao) {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<GoodBook> rst = new ArrayList<GoodBook>();
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer("insert into book(xuhao) values(" + xuhao + ")");
            ResultSet rs = stmt.executeQuery(sql.toString());
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return;
    }
    //通过扫一扫进行显示对应书籍的全部内容
    public static ArrayList<BookInfo> saoyisao(String xuhao) {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<BookInfo> rst = new ArrayList<BookInfo>();
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("saoyisao:连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            // int shu=Integer.parseInt(xuhao);
            StringBuffer sql = new StringBuffer("select  book.xuhao,bookname,zongliang,yuliang,sj_number,leixing,image from   book,book_image  where  book.xuhao='" + xuhao + "'  and  book.xuhao=book_image.xuhao");
            ResultSet rs = stmt.executeQuery(sql.toString());
            while (rs.next()) {
                BookInfo dto = new BookInfo();
                dto.setXuhao(rs.getInt("xuhao"));
                dto.setBookname(rs.getString("bookname"));
                dto.setZongliang(rs.getInt("zongliang"));
                dto.setYuliang(rs.getInt("yuliang"));
                dto.setSj_number(rs.getString("sj_number"));
                dto.setLeixing(rs.getString("leixing"));
                dto.setImage(rs.getString("image"));
                rst.add(dto);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("      saoyisao:连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return rst;
    }
    //搜索对应书籍的信息———计算机、数学、中文、外语、护理、体育、经济
    public static ArrayList<BookInfo> booktype(String leixing) {
        Connection conn = null;
        Statement stmt = null;
        //   ArrayList<BookInfo> rst = new ArrayList<BookInfo>();
        ArrayList<BookInfo> rst = new ArrayList<BookInfo>();
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("booktype:连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer("select book.xuhao,bookname,zongliang,yuliang,sj_number,leixing,image from   book ,book_image where book.xuhao=book_image.xuhao and leixing='" + leixing + "'");
            ResultSet rs = stmt.executeQuery(sql.toString());
            while (rs.next()) {
                BookInfo dto = new BookInfo();
                dto.setXuhao(rs.getInt("xuhao"));
                dto.setBookname(rs.getString("bookname"));
                dto.setZongliang(rs.getInt("zongliang"));
                dto.setYuliang(rs.getInt("yuliang"));
                dto.setSj_number(rs.getString("sj_number"));
                dto.setLeixing(rs.getString("leixing"));
                dto.setImage(rs.getString("image"));
                rst.add(dto);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("      booktype:连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return rst;
    }
 //个人借阅书籍导入数据表操作————————导入<借阅表>
    public static void insertjieyue(String xuhao,String number) {
        Connection conn = null;

        Statement stmt = null;
        Statement stmt1 = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("insertjieyue:连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt1 = conn.createStatement();
            int s = Integer.parseInt(xuhao);
            //获取当前时间
             SimpleDateFormat  df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String time=df.format(new Date());
             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
             Date  dateTime = simpleDateFormat.parse(time);
            StringBuffer sql = new StringBuffer("insert into jieyue(xuhao,number,time) values ('" + s + "','"+number+"','"+time+"')");
           String  st="update book set  yuliang=yuliang-1  where  xuhao='"+xuhao+"' ";
            int count = stmt.executeUpdate(sql.toString());
            int m = stmt1.executeUpdate(st.toString());    //对应书籍yuliang减一
            System.out.println(xuhao);
            stmt.close();
            stmt1.close();
            conn.close();
            System.out.println("      insertjieyue:连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println(xuhao);
        return;
    }
    //实现还书
    public static void huanshu(String xuhao,String number) {
        Connection conn = null;
        Statement stmt = null;
        Statement stmt1 = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("huanshu:连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt1 = conn.createStatement();
            int s = Integer.parseInt(xuhao);
            StringBuffer sql = new StringBuffer("delete  from jieyue  where  xuhao='" + xuhao + "' and number='"+number+"'");
            String st="update  book set yuliang=yuliang+1  where  xuhao='"+xuhao+"'";    //对应书籍yuliang加一
            int count = stmt.executeUpdate(sql.toString());
            int m = stmt1.executeUpdate(st.toString());
            System.out.println(xuhao);
            stmt.close();
            conn.close();
            System.out.println("      huanshu:连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println(xuhao);
        return;
    }
    //用户信息导入数据表操作————————导入<user>        注:目前还没有完成(原因:小程序中的值传不过来)
    public static void insertStudent(String number, String name, String phone, String fyzy) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("insert_student:连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer("insert into student(number,name,phone,fyzy) values ('" + number + "','" + name + "','" + phone + "','" + fyzy + "')");
            int count = stmt.executeUpdate(sql.toString());
            System.out.println(count);
            System.out.println(fyzy);
            stmt.close();
            conn.close();
            System.out.println("      insert_student:连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return;
    }
    //搜索书籍的具体内容——————进行展示对应小程序中的spdetail页面
    public static ArrayList<book_content> bookcontent(int xuhao,String number) {
        Connection conn = null;
        Statement stmt = null;
        Connection conn1 = null;
        Statement stmt1 = null;
        boolean  flag=false;
        ArrayList<book_content> rst = new ArrayList<book_content>();
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("book_content:连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn1 = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt1 = conn1.createStatement();
            StringBuffer sql = new StringBuffer("select yuliang,leixing,content,book_content.xuhao,image,book_content.bookname  from book_content ,book_image,book where book_content.xuhao='" + xuhao + "' and book_content.xuhao=book_image.xuhao  and book.xuhao=book_content.xuhao");
            String  s="select * from sc where (xuhao='"+xuhao+"' and number='"+number+"')";
            ResultSet rs = stmt.executeQuery(sql.toString());
            ResultSet s1 = stmt1.executeQuery(s.toString());
            if(s1.isBeforeFirst()) {
             flag=true;
            }
            while (rs.next()) {
                book_content dto = new book_content();
                dto.setXuhao(rs.getInt("xuhao"));
                dto.setBookname(rs.getString("bookname"));
                dto.setContent(rs.getString("content"));
                dto.setImage(rs.getString("image"));
                dto.setYuliang(rs.getInt("yuliang"));
                dto.setLeixing(rs.getString("leixing"));
                dto.setFlag(flag);
                rst.add(dto);
            }
            rs.close();
            stmt.close();
            conn.close();
            s1.close();
            stmt1.close();
            conn1.close();
            System.out.println("      book_content:连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (stmt1 != null) stmt1.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn1 != null) conn1.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return rst;
    }
    //实现小程序中借阅查询板块显示内容-------对应小程序中xiaoxi页面
    public static ArrayList<ShowJIe> jieyue(String  number) {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<ShowJIe> rst = new ArrayList<ShowJIe>();
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("jieyue:连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer("select  jieyue.time,jieyue.xuhao,book.bookname,jieyue.number,name from  jieyue,book,student where jieyue.xuhao=book.xuhao and jieyue.number=student.number  and  jieyue.number='"+number+"'");
            ResultSet rs = stmt.executeQuery(sql.toString());
            while (rs.next()) {
                ShowJIe dto = new ShowJIe();
                dto.setBookname(rs.getString("bookname"));
                dto.setTime(rs.getDate("time"));
                dto.setNumber(rs.getString("number"));
                dto.setName(rs.getString("name"));
                dto.setXuhao(rs.getString("xuhao"));
                rst.add(dto);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("      jieyue:连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return rst;
    }
    //实现小程序中收藏板块，加1操作
    public static void shoucang(String  number,String xuhao) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("shoucang:连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer("insert  into  sc(number,xuhao)  values('"+number+"','"+xuhao+"')");
            int count = stmt.executeUpdate(sql.toString());
            System.out.println(count);
            stmt.close();
            conn.close();
            System.out.println("      shoucang:连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return;
    }
    //实现小程序中取消收藏板块，减1操作
    public static void quxiaoshoucang(String number,String xuhao) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("quxiaoshoucang:连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer("delete    from  sc  where number='"+number+"'  and xuhao='"+xuhao+"'");
            int count = stmt.executeUpdate(sql.toString());
            System.out.println(count);
            stmt.close();
            conn.close();
            System.out.println("      quxiaoshoucang:连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return;
    }
    //实现好书分享板块，根据收藏数进行获取书的具体内容
    public static ArrayList<Good_book> good_kook() {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Good_book> rst = new ArrayList<Good_book>();
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("good_book:连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer("select  sc.xuhao,content,bookname,image, count(*) as count1 from sc,book_content,book_image where  sc.xuhao=book_content.xuhao and  sc.xuhao=book_image.xuhao GROUP BY sc.xuhao order by count1 desc  limit 0,5;\n" +
                    "  ");
            ResultSet rs = stmt.executeQuery(sql.toString());
            while (rs.next()) {
                Good_book dto = new Good_book();
                dto.setXuhao(rs.getString("xuhao"));
                dto.setBookname(rs.getString("bookname"));
                dto.setContent(rs.getString("content"));
                dto.setImage(rs.getString("image"));
                rst.add(dto);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("      good_book:连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return rst;
    }
    //小程序首页猜你喜欢板块
    public static ArrayList<BookInfo> lovebook() {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<BookInfo> rst = new ArrayList<BookInfo>();
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("lovebook:正在连接数据库......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer("select  book.xuhao,bookname,zongliang,yuliang,sj_number,leixing,image FROM book,book_image where book.xuhao=book_image.xuhao  order by  rand() limit 5 ");
            ResultSet rs = stmt.executeQuery(sql.toString());
            while (rs.next()) {
                BookInfo dto = new BookInfo();
                dto.setXuhao(rs.getInt("xuhao"));
                dto.setBookname(rs.getString("bookname"));
                dto.setZongliang(rs.getInt("zongliang"));
                dto.setYuliang(rs.getInt("yuliang"));
                dto.setSj_number(rs.getString("sj_number"));
                dto.setLeixing(rs.getString("leixing"));
                dto.setImage(rs.getString("image"));
                rst.add(dto);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("      lovebook:连接数据库成功......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return rst;
    }
//修改phone
public static void updatephone(String number,String phone) {
    Connection conn = null;
    Statement stmt = null;
        try {
        Class.forName(JDBC_DRIVER);
        System.out.println("updatephone:连接数据库......");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        StringBuffer sql = new StringBuffer("update   student  set  phone= '"+phone+"'  where  number='" + number+ "'");
        int count = stmt.executeUpdate(sql.toString());
        System.out.println(count);
        stmt.close();
        conn.close();
        System.out.println("      updatephone:连接数据库成功......");
    } catch (SQLException se) {
        se.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException se2) {
        }
        try {
            if (conn != null) conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
        return;
  }
  //收藏的书
  public static ArrayList<Shoucang_book> shoucang_book(String number) {
      Connection conn = null;
      Statement stmt = null;
      Connection conn1 = null;
      Statement stmt1 = null;
      boolean flag=false;
      ArrayList<Shoucang_book> rst = new ArrayList<Shoucang_book>();
              try {
          Class.forName(JDBC_DRIVER);
          System.out.println("shoucang_book:正在连接数据库......");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          stmt = conn.createStatement();
          conn1 = DriverManager.getConnection(DB_URL, USER, PASS);
          stmt1 = conn1.createStatement();
          StringBuffer sql = new StringBuffer("select  sc.xuhao,content,image,book.bookname from  sc,book_content,book_image,book  where  sc.xuhao=book.xuhao and sc.xuhao=book_content.xuhao and sc.xuhao=book_image.xuhao and sc.number='"+ number + "'");
          String  s="select * from sc where  number='"+number+"'";
          ResultSet rs = stmt.executeQuery(sql.toString());
          ResultSet s1 = stmt1.executeQuery(s.toString());
          if(s1.isBeforeFirst()) {
              flag=true;
          }
          while (rs.next()) {
              Shoucang_book  dto = new Shoucang_book();
              dto.setXuhao(rs.getInt("xuhao"));
              dto.setBookname(rs.getString("bookname"));
              dto.setContent(rs.getString("content"));
              dto.setImage(rs.getString("image"));
              dto.setFlag(flag);
              rst.add(dto);
          }
          rs.close();
          s1.close();
          stmt.close();
          conn.close();
          stmt1.close();
          conn1.close();
          System.out.println("      shoucang_book:连接数据库成功......");
      } catch (SQLException se) {
          se.printStackTrace();
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          try {
              if (stmt != null) stmt.close();
          } catch (SQLException se2) {
          }
          try {
              if (conn != null) conn.close();
          } catch (SQLException se) {
              se.printStackTrace();
          }
      }
      return rst;
  }
}
