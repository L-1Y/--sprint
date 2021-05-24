var util = require('../../js/util.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: [],
    xuhao: '',
    name:'',
    time:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (e) {
    var time = util.formatTime(new Date());
    var app=getApp();
    var id = e.result;      //定义
    var that = this;
    this.setData({
      xuhao: e.result,
      name:app.globalData.name,
      time:time
    })
    this.data.currentId = id;         //赋值
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

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    
  },
  /*还书 */
  login: function (e) {
    let number;
    var app = getApp();
    wx.request({
      url: 'http://localhost:8080/login/huanshu',
      data: {
        xuhao: this.data.currentId,
        number: app.globalData.number
      },
      success(res) {
        console.log(res);
         wx.showToast({      //扫描成功显示小页面
          title: '还书成功',
          icon: 'success',
          duration: 3000,
           complete:
             wx.navigateBack({
               delta: 1
             })
        })
      },
      fail: function (res) {
        wx.showToast({      //扫描成功显示小页面
          title: '还书失败',
          icon: 'none',
          duration: 3000,
        })
      },
    })
  },

})