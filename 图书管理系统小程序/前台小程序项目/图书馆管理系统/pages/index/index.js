var WxAutoImage = require('../../js/wxAutoImageCal.js');
var app = getApp();

Page({
    data: {
        imgUrls: [
            '../../image/indexswiper1.jpg',
            '../../image/index2.png',
            '../../image/index3.jpg'
        ],
        indicatorDots: true,
        vertical: false,
        autoplay: true,
        interval: 3000,
        duration: 1200,
      list: [],    //定义空列表，用来封装返回的数据
        iconArray: [
            {
                "iconUrl": '../../image/all.png',
                "iconText": '全部',
                "tzUrl": '../all/all' 
            },
            {
                "iconUrl": '../../image/jisuanji.png',
              "iconText": '计算机',
              "tzUrl": '../computer/computer' 
            },
            {
                "iconUrl": '../../image/shuxue.png',
              "iconText": '数学',
              "tzUrl": '../math/math' 
            },
            {
                "iconUrl": '../../image/zhongwen.png',
              "iconText": '中文',
              "tzUrl": '../chinese/chinese' 
            },
            {
                "iconUrl": '../../image/waiyu.png',
              "iconText": '外语',
              "tzUrl": '../foreign/foreign' 
            },
            {
                "iconUrl": '../../image/huli.png',
              "iconText": '护理',
              "tzUrl": '../care/care' 
            },
            {
                "iconUrl": '../../image/tiyu.png',
              "iconText": '体育',
              "tzUrl": '../pe/pe' 
            },
            {
                "iconUrl": '../../image/jingji.png',
              "iconText": '经济',
              "tzUrl": '../economy/economy' 
            }
        ],
        itemArray: [
            {
                "itemUrl": '../../image/huaju.jpeg',
                "itemText": '11月20日话剧《风声》'
            },
            {
                "itemUrl": '../../image/huaju.jpeg',
                "itemText": '11月20日话剧《原野》'
            },
            {
                "itemUrl": '../../image/huaju.jpeg',
                "itemText": '11月28日“夜店”演唱会'
            },
        ]
    },
    cusImageLoad: function(e){
        var that = this;
        that.setData(WxAutoImage.wxAutoImageCal(e));
    },
    //猜你喜欢
  onLoad: function (e) {
    var that = this;
    wx.showModal({
      title: '提示',
      content: '用户尚未登陆',
      success: function(res) {
          if (res.confirm) {
          console.log('用户点击确定')
          } else if (res.cancel) {
          console.log('用户点击取消')
          }
      }
  })
    wx.request({  
      url: 'http://localhost:8080/login/lovebook',
      data: {
      },
      success(res) {
        console.log("数据库连接成功",res);
        that.setData({
          list: res.data
        })
      },
      fail(res){
        console.log("数据库连接失败：",res)
      }
    })
  },
})