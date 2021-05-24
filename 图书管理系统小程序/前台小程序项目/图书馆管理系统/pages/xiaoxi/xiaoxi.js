var app = getApp()
Page({
  	data: {
      list: [],
      denglu:'',
  	},
  	carAdd: function(event){
  		var that = this;
  		var index = event.target.dataset.alphaBeta;
  		var con = that.data.carArray[index].carNum + 1;
  		var key = 'carArray['+index+'].carNum';
  		var obj = {};
  		obj[key] = con;
  		this.setData(obj);
  	},
  	carReduce: function(event){
  		var that = this;
  		var index = event.target.dataset.alphaBeta;
  		var con = that.data.carArray[index].carNum;
  		var key = 'carArray['+index+'].carNum';
  		var obj = {};
  		if(con <= 1){
  			obj[key] = 1;
  			that.setData(obj);
  		}
  		else {
  			con--;
  			obj[key] = con;
  			that.setData(obj);
  		}
  	},
  	carRemove: function(event){
  		var that = this;
  		var index = event.target.dataset.alphaBeta;
  		var key = 'carArray['+index+'].carShow';
  		var obj = {};
  		obj[key] = false;
  		this.setData(obj);
  	},
    toPay: function(){
        wx.navigateTo({
          url: '../pay/pay'
        })
    },
    //显示借阅信息

  onLoad: function (e) {   
    // var that = this;
    // wx.request({
    //   url: 'http://localhost:8080/login/jieyue',
    //   data: {
    //   },           
    //   success(res) {
    //     console.log(res);
    //     that.setData({
    //       list: res.data
    //     })
    //     }
    
    // })
  
 
},

  return1:function(e){
    var number;
    var that = this;
    var app=getApp();
    number=app.globalData.number
    wx.request({
      url: 'http://localhost:8080/login/guihuan',
      data: {
        number: app.globalData.number,
       xuhao:"123"
      },
      success(res) {
        console.log(res);
        that.setData({
          list: res.data
        })
      }
  })
  } ,

  //页面生命周期函数--监听页面初次渲染完成
  onReady: function () {
  

  },

  //页面 生命周期函数--监听页面显示
  onShow: function () {
    var that = this;
    var app= getApp();
    wx.request({
      url: 'http://localhost:8080/login/jieyue',
      data: {
        number:app.globalData.number
      },           
      success(res) {
        console.log(res);
        that.setData({
          list: res.data
        })
        console.log(that.list)
        }
    })
    let denglu;
    if(app.globalData.number==null){
      denglu= false;
    }else{
      denglu=true;
      
    }
    that.setData({
      denglu:denglu,

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
})
