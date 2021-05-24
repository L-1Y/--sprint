// pages/jscondaction/jscondaction.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    accounts: ["计算机", "数学", "中文", "外语", "护理", "体育", "经济", "其他"],
    accountIndex: 0,
    number: '',
    name: '',
    phone: '',
    fyzy: '',
    inputarray: [{
        "inputtext1": '学号',
        "inputtext2": '请输入学号',
        "inputname": 'input1'
      },
      {
        "inputtext1": '姓名',
        "inputtext2": '请输入姓名',
        "inputname": 'input2'
      },
      {
        "inputtext1": '联系方式',
        "inputtext2": '请输入联系方式',
        "inputname": 'input3'
      }
    ]
  },
  bindAccountChange: function(e) {
    console.log('picker account 发生选择改变，携带值为', e.detail.value);

    this.setData({
      accountIndex: e.detail.value
    })
  },
  popConfirm: function(e) {

    var that = this;
    this.setData({
      number: e.detail.value.input1,
      name: e.detail.value.input2,
      phone: e.detail.value.input3,
      fyzy: this.data.accounts[e.detail.value.select1],
    })

    var app = getApp();
    app.globalData.number = e.detail.value.input1,
      app.globalData.name = e.detail.value.input2,
      app.globalData.phone = e.detail.value.input3,
      app.globalData.fyzy = this.data.accounts[e.detail.value.select1],


      console.log(app.globalData.number);
    console.log(app.globalData.name);
    console.log(app.globalData.phone);
    console.log(app.globalData.fyzy);
    wx.request({
      url: 'http://localhost:8080/login/insert_student',
      data: {
        number: e.detail.value.input1,
        name: e.detail.value.input2,
        phone: e.detail.value.input3,
        fyzy: this.data.accounts[e.detail.value.select1],
      },
      success(res) {
        console.log(res);
        wx.navigateBack({
          delta: 1
        })
      }
    })


    // wx.showModal({
    //   title: '确认提示',
    //   content: '请确认你的信息，一经确认无法修改',
    //   success: function (e) {
    //     if (e.confirm) {
    //       console.log('点击确认回调')
    //       //
    //     } else {
    //       console.log('点击取消回调')
    //     }
    //   }
    // })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

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

  }
})