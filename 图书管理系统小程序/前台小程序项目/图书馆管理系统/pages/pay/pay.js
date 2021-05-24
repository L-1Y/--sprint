var util = require('../../js/util.js');
Page({
  data: {
    list: [],
    xuhao: '',
    name: '',
    time: '',
  },
  onLoad: function(e) {
    var time = util.formatTime(new Date());
    var app = getApp();
    var id = e.result; //定义
    var that = this;
    this.setData({
      xuhao: e.result,
      name: app.globalData.name,
      time: time
    })
    this.data.currentId = id;  //赋值
    wx.request({
      url: 'http://localhost:8080/login/saoyisao',
      data: {
        xuhao: e.result,
      },
      success(res) {
   
        console.log(res);

        that.setData({
          list: res.data,
        })

      }
    })
  },
  login: function(e) {
    var app = getApp();
    wx.request({
      url: 'http://localhost:8080/login/insertjieyue',
      data: {
        xuhao: this.data.currentId,
        number: app.globalData.number
      },
      success(res) {
        
        console.log(res);
        wx.showToast({ //扫描成功显示小页面
            title: '借阅成功',
            icon: 'success',
            duration: 3000,
          complete: 
          wx.navigateBack({
            delta: 1
          })
          })
    
      }
    })
  },

})