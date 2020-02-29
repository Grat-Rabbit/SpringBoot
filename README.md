"# SpringBoot-" 
编写目的：集成了一些方便使用的功能类，下次用的时候直接套入这个模板即可

"# SpringBoot-" 
需要注意的：
1.在controller中有一个测试jwt的方法：token
先决条件：数据库库名为：test,表名为:user，列名有userid和password
并且，userId为：14001 password：1
获取token的主要代码在UserServiceImpl中的getToken方法中
利用userId和password生成，若不想用这种也可以自己更改
2.利用jwt实现登录，主要token代码在utils.interceptor包中：AuthenticationInterceptor类实现拦截，同时annatation包中存放着两个注解类@PassToken和@UserLoginToken，分别代表是否需要验证用户是否登录。同时，LevelAuthrntication包中放着各个不同权限的那等级的注解，是否使用看情况。所以关于User的各个类和操作必须有，才能获取User的各种信息，所以配套User的Service Dao Mapper文件，这里的token是由userId转成的。

3.MultiRequestBody注解的使用：可以获取传入对应mapping的json数据
例如：    public Result login(@MultiRequestBody String identity){
        System.out.println(identity);
    }
可以获得：xxxx
{
    "identity":"xxxx"	
}

4.InterfaceExceptionHandler的使用是拦截所有异常
