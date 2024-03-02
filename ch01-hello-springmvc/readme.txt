实现步骤:用户在页面发起一个请求，交给springMVC的控制器对象处理

实现步骤
新建maven工程
加入依赖
    spring-mvc依赖，间接把spring依赖加入项目
    jsp，servlet依赖
重点:在web.xml中注册springmvc的核心对象DispatcherServlet
    1.DispatcherServlet叫做中央调度器，是一个Servlet,它的父类是继承HttpServlet
    2.DispatcherServlet页叫做前端控制器(front controller)
    3.DispatcherServlet负责接收用户的请求，调用其他的控制器对象，并把请求的结果显示给用户
创建一个请求发起页面index.jsp
创建控制器(即处理器)类
    1.在类的上面加入Controller注解，创建对象，并放入到springMVC容器中
    2.在类的方法上面加入RequestMapping注解
创建一个作为结果的jsp，显示请求的处理结果
创建springmvc的配置文件(同spring的配置文件)
声明组件扫描器，声明@Controller所在的包
声明视图解析器，帮助处理视图

