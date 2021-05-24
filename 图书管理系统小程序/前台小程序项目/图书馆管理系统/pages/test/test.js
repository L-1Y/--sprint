var app=getApp()
Page({
  data: {
    result:"" ,
    result1:""
  }, 
  scancode: function () {
    let that = this;
    let result;
    wx.scanCode({
      success: (res) => {
        this.result = res.result;
        that.setData({
          result: this.result,
           number: app.globalData.number
        })
        wx.showToast({      //扫描成功显示小页面
          title: '扫描成功',
          icon: 'success',
          duration: 8000,   
        })   
        wx.navigateTo({         //扫描成功跳转页面
          url: '../pay/pay?result=' + res.result, 
        })
      },
      fail: (res) => {    //扫描失败显示小页面
        wx.showToast({
          title: '扫描失败',
          icon: 'none',
         // image: '../../image/shibai.png',    //图标，优先级高于icon
          duration: 4000
        })
      }
    })
  },//扫一扫功能
  scancode1: function () {
    let that = this;
    let result;
    wx.scanCode({
      success: (res) => {
        this.result = res.result;
        that.setData({
          result: this.result
        })
        //拿全局变量的值----进行判断
       /* if (app.globalData.name == null) {
          wx.navigateTo({         //没登录时候---跳转到登录页面
            url: '../jscondaction/jscondaction'
          })
        }
        */
        wx.showToast({      //扫描成功显示小页面
          title: '扫描成功',
          icon: 'success',
          duration: 8000,

        })
        wx.navigateTo({         //扫描成功跳转页面
          url: '../huan/huan?result=' + res.result,

        })
      },
      fail: (res) => {    //扫描失败显示小页面
        wx.showToast({
          title: '扫描失败',
          icon: 'none',
          // image: '../../image/shibai.png',      //图标，优先级高于icon
          duration: 4000
        })
      }
    })
  },
  //页面 生命周期函数--监听页面显示
  onShow: function () {
    if (app.globalData.name == null) {
      wx.navigateTo({         //没登录时候---跳转到登录页面
        url: '../jscondaction/jscondaction'
      })
      wx.showToast({      //扫描成功显示小页面
        title: '您尚未完善信息',
        icon: 'success',
        duration: 4000,
      })
    }
  },
})
