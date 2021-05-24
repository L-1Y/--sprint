// pages/myinfo/myinfo.js
var that = this;
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    number: '',
    name: '',
    phone: '',
    fyzy: '',
    denglu: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(e) {
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    let denglu;
    if (app.globalData.number != null) {
      denglu = true;
    } else {
      denglu=false;
      wx.navigateTo({ //没登录时候---跳转到登录页面
        url: '../jscondaction/jscondaction'
      })
    }
    this.setData({
      denglu: denglu
    })
    let number;
    let name;
    let phone;
    let fyzy;
    this.setData({
      name: app.globalData.name,
      number: app.globalData.number,
      phone: app.globalData.phone,
      fyzy: app.globalData.fyzy,
    })

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})