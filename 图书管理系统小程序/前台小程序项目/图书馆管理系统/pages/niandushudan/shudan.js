Page({
  data: {
    list: [],
    img: [
      '../../image/book/a.jpg',
      '../../image/book/b.jpg',
      '../../image/book/c.jpg',
      '../../image/book/d.jpg',
      '../../image/book/e.jpg',
      '../../image/book/f.jpg',
      '../../image/book/g.jpg',
      '../../image/book/h.jpg',
      '../../image/book/i.jpg',
      '../../image/book/j.jpg',
      '../../image/book/k.jpg'
    ],
  },


  onLoad: function (e) {
    console.log(e);
    var that = this;
    wx.request({
      url: 'http://localhost:8080/login/allInfo',
      data: {
      },
      success(res) {
        console.log(res);
        that.setData({
          list: res.data
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

  }
})