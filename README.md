# "# SpringBoot"
## 编写目的：
        集成了一些方便使用的功能类，下次用的时候直接套入这个模板即可<br>  
## 目前已经集成的小功能：
        * 1.实现简易jwt
        * 2.在controller可直接获取json数据
        * 3.全局异常捕捉
`注意点`：<br>  
* 1.在controller中有一个测试jwt的方法：`token`<br>  
>先决条件：数据库库名为：test,表名为:user，列名有userid和password<br>  
>并且，userId为：14001 password：1<br>  
>获取token的主要代码在UserServiceImpl中的getToken方法中<br>  
>利用userId和password生成，若不想用这种也可以自己更改<br>  
* 2.利用jwt实现登录，主要token代码在utils.interceptor包中：<br>  
>AuthenticationInterceptor类实现拦截<br>  
>annatation包中存放着两个注解类@PassToken和@UserLoginToken<br>  
>分别代表是否需要验证用户是否登录         <br>  
>>同时，LevelAuthrntication包中放着各个不同权限的那等级的注解<br>  
 是否使用看情况。<br>  
 >所以关于User的各个类和操作必须有，才能获取User的各种信息，<br>  
 >>所以配套User的Service Dao Mapper文件，这里的token是由userId转成的。<br>  

* 3.MultiRequestBody注解的使用：可以获取传入对应mapping的json数据<br>  
>```json
>json传值：
>{
>    "identity":"xxxx"	
>}

>```java
>public Result login(@MultiRequestBody String identity){
>        System.out.println(identity); //可以获得xxxx
>    }




* 4.InterfaceExceptionHandler的使用是拦截所有异常<br>  
