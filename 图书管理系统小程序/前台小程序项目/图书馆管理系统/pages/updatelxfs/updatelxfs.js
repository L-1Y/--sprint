// pages/updatelxfs/updatelxfs.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    phone: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    let phone;
    var that = this;
    var app = getApp();
    this.setData({
      phone: app.globalData.phone,
    })
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

  },

  update: function(e){
   var that = this;
    var app=getApp()
    app.globalData.phone = e.detail.value.input1
    this.setData({
      phone: e.detail.value.input1,
    })
    wx.request({
      url: 'http://localhost:8080/login/updatephone',
      data: {
        number: app.globalData.number,
        phone: e.detail.value.input1
      },
      success(res) {
        console.log(res);
        wx.navigateBack({
          delta:2
        })
      }
    })
  }
})