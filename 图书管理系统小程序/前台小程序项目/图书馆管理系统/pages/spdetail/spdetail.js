var WxAutoImage = require('../../js/detailImage.js');
var app = getApp();
Page({
    data: {
        list:[],
        indicatorDots: true,
        vertical: false,
        autoplay: true,
        interval: 3000,
        duration: 1200,
        denglu:'',
        iscollect:false
    },
    collect: function(e){    //收藏操作的按钮
      var that = this;
      var app=getApp();
        this.setData({
         iscollect: !this.data.iscollect,
         xuhao: this.data.xuhao,
        })   
        console.log(this.data.iscollect);
        //点击取消收藏按钮
      if (!this.data.iscollect){
        wx.request({
          url: 'http://localhost:8080/login/quxiaoshoucang',
        data: {
          xuhao: this.data.xuhao,
          number: app.globalData.number
        },
        success(res) {
          console.log(res);
        }
      })
      }
      //点击收藏按钮
      else if (this.data.iscollect){
        wx.request({
          url: 'http://localhost:8080/login/shoucang',
     
          data: {
            xuhao: this.data.xuhao,
            number: app.globalData.number
          },
          success(res) {
            console.log(res);
          }
        })


      }
      
    },
    cusImageLoad: function(e){
        var that = this;
        that.setData(WxAutoImage.wxAutoImageCal(e));
     },
     onLoad:function(e){
       var that = this;
       this.setData({
         xuhao: e.xuhao,
       })
     },
  onShow: function () {
    let denglu;
    var that = this;
    console.log(that.iscollect);
    wx.request({
      url: 'http://localhost:8080/login/book_content',
      data: {
        xuhao: that.data.xuhao,
        number: app.globalData.number
      },
      success(res) {
        console.log(res);
        that.setData({
          list: res.data,
        })
      }
    })
    if (app.globalData.number == null) {
      denglu = false;
    } else {
      denglu = true;
    }
    that.setData({
      denglu: denglu,
    })


  }

 })
