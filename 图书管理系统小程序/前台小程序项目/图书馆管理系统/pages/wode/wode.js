var app = getApp();

Page({
  	data: {
      denglu:false,
  		userInfo: {},
      iArray: [
        {
          "tzUrl": '../shouchang/shouchang',
          "iconText": '我的收藏'
        },
        {
          "tzUrl": '../myinfo/myinfo',
          "iconText": '我的信息'
        },
        {
          "tzUrl": '../lxkf/lxkf',
          "iconText": '联系客服'
        },
        {
          "tzUrl": '../aboutus/aboutus',
          "iconText": '关于我们'
        },
        {
          "tzUrl": '../niandushudan/shudan',
          "iconText": '年度书单'
        },
        
        ]

  	},
  	onLoad: function() {

  	},
    //生命周期函数--监听页面初次渲染完成
  onReady: function () {
   
  },
  //页面 生命周期函数--监听页面显示
  onShow: function () {
    var that=this;
    var app=getApp();
    let denglu;
    if (app.globalData.number == null) {
      denglu = false;
    } else {
      denglu = true;

    }
    that.setData({
      denglu: denglu,

    })
    
    // if (app.globalData.name == null) {
    //   wx.navigateTo({         //没登录时候---跳转到登录页面
    //     url: '../jscondaction/jscondaction'
    //   })
    //   wx.showToast({      //扫描成功显示小页面
    //     title: '您尚未完善信息',
    //     icon: 'success',
    //     duration: 4000,
    //   })
    // }
  },
  logout: function(){
    var that=this;
    var app=getApp();
    app.globalData.number = null;
    app.globalData.name = null;
    app.globalData.phone = null;
    app.globalData.fyzy = null;
    wx.showToast({
      title: '退出成功',
      icon: 'success',
      duration: 3000,
    })
    that.onShow();


  }
})