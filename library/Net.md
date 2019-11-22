#### 请求部分目前进度

* Rxjava接入
* 异常未处理
* 初步请求封装

#### 框架模式

##### mvvm构思(优先实现),主要作用类:

* `Repository`: 用于分流数据获取渠道(SP/Database/api...),减缓vm类逻辑

* `ViewModel` VM层: 这是MVVM重要的组成部分,用于数据处理,分发至V层,如加了`databinding`,则分发至V层和xml布局,不能持有`View`的引用

* `Activity/Fragment` V层,用于展示`viewmodel`分发下来的数据,尽量不要持有数据获取能力

* `Api` 接口数据api,这个单独抽出主要是想可以和`MVP`的P层共用

##### mvp 还没动手

#### 封装思路(暂以自己项目为例,并优先考虑kotlin)

##### 接口请求结构体:

```
{
    "code" : 0 
    "message" : ""
    "data" : {}
}
```
* 目前结构体大都为这样的方式,但是每个项目不一样,不能在library中定死,

* 但是这样的结构体必然通过code来判断是否失败,如成功返回`data`,失败`code = 0`,
并且`data`返回相应数据。

* 所以目前定义了一个类`NetResponse`,用来获取失败还是成功

* 项目中的使用这样的数据结构体的话,不管字段是什么,只要抽取出顶层bean,并继承,一般来说顶层的bean不会去继承别的类,有的话就需要考虑怎么再改造

* 做这个步骤主要是为了能成功时把data抽离出来,失败直接抛入异常,并把整个`bean`转成jsonString到异常信息去处理

* 处理的步骤就是通过`RxJava`的`map`操作符,具体实现:`ApiConvers.kt`

#### RetrofitBuilder

这个目前还没完善,大致的思路是`library`里完成配置选项,在项目里使用`NetConfig.kt`来配置相关需要的操作,例如
header/拦截器/cache/证书/等等配置项操作,目前只配置了`BaseUrl`

#### 异常处理
目前还没写到,按以前的思路来说是通过`ApiConvers.kt`分发下来的`onError(t : Throw)`,来实现一个`BaseObservable.kt`
来获取异常信息,再判断与`ApiException`来进行具体业务逻辑,此处需要一个更好的思路