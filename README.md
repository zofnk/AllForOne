### 暂定第一版更新内容 19.11.11

#### 网络框架
>基础框架为OkHttp
* 以Retrofit + Rxjava或以Kotlin + Coroutine为基础封装
* 添加缓存策略(非Okhttp自带)
* 添加请求进度
* 添加Glide加载进度
* 生命周期捆绑
* 取消请求任务

#### 图片框架
>暂定Glide
* Glide Load Image封装

#### 数据库框架
* [LitePal](https://github.com/LitePalFramework/LitePal)
* [greenDAO](https://github.com/greenrobot/greenDAO)
* [room](https://developer.android.com/topic/libraries/architecture/room)

可以尽量向[Google Jetpack]([https://developer.android.com/jetpack](https://developer.android.com/jetpack)
)靠齐,推荐采用[ROOM](https://developer.android.com/topic/libraries/architecture/room)

#### 屏幕适配方案
* [今日头条](https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA)
* [AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode)

#### 缓存策略
* AOP实现拦截请求缓存
* OkHttp添加拦截器
* 手动封装进请求框架保存请求至SQLite

#### 状态页
* [LoadSir](https://github.com/KingJA/LoadSir/)
*
*

#### 对话框
* [XPopup](https://github.com/li-xiaojun/XPopup) 此框架还有实现了类似微信朋友圈点开大图并拖拽关闭的功能

#### Utils
* 用kotlin添加各种KTX类
* 用kotlin实现尽量打上`@JvmStatic`注解适配java

#### 权限申请
* [PermissionsDispatcher](https://github.com/permissions-dispatcher/PermissionsDispatcher)
* [RxPermissions](https://github.com/tbruyelle/RxPermissions/)

#### 版本更新
* 可以以[XPopup](https://github.com/li-xiaojun/XPopup),OkHttp,权限申请来自己封装

#### 顶层基类
* BaseActivity
  1.statusBar沉浸式
  2.toolsBar样式
  3.状态页封装
  4.MVP/MVVM框架
  5.ktx扩展类
* BaseFragment
  1.懒加载
  2.hide/show/replace
* RecyclerViewAdapter
  1.MVVM可以扩展进ViewModel中

#### 社会化分享能力
* 使用友盟或者极光完成

#### 消息推送能力
* 同社会化分享使用同个SDK

#### 地图定位能力
* 高德/百度地图

#### 视屏处理能力
* 可以针对[GSYVideoPlayer](https://github.com/CarGuo/GSYVideoPlayer/)再次封装
* 可以深度学习/扩展视屏方向,但是有很大的难度
