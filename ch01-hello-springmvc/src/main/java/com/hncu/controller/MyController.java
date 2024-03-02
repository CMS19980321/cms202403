package com.hncu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
*  @Controller:创建处理器对象，对象放在soringMVC容器中
*  位置:在类的上面
*
*  能处理请求的是控制器(处理器)，也叫做后端控制器
*/
@Controller
public class MyController {
    /*
    *  处理用户的请求，在springMVC中是使用方法来进行处理的
    *  方法是自定义的，可以有多种返回值，多种参数，方法名自定义
    *
    * */

    /*
    *  准备使用doSome方法处理some.do请求，
    *  @RequestMapping：请求映射，作用是将请求地址和一个方法绑定在一起，一个请求指定一个方法进行处理
    *     属性:value 是一个String类型，表示请求的url地址(some.do),value的值必须是唯一的，推荐地址以"/"，"/"表示根地址
    *     位置:1.在方法的上面，比较常用
    *          2.在类的上面
    *
    *  使用@RequestMapping注解修饰的方法是处理器方法或者控制器方法
    *  使用@RequestMapping修饰的方法可以处理请求，类型Servlet中固定doGet,doPost方法
    *
    *  返回值:ModelAndView:表示这次请求处理的返回结果
    *  Model:数据，请求处理完毕后，哟显示给用户的数据
    *  View:视图,比如jsp之类
    * */
    @RequestMapping(value = {"/some.do","/first.do"}) //这里/代表项目的根，即http://localhost:8080/
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();
        //添加的对象，框架最后会把数据放入到request作用域中
        //相当于request.setAttribute("key",value)
        mv.addObject("msg","欢迎使用springMVC做开发");
        mv.addObject("fun","执行的是doSome方法");

        //指定视图，指定视图的完整路径
        //框架对视图执行forward操作，request.getRequestDispatcher("/show.jsp").forward()
        // mv.setViewName("/WEB-INF/view/show.jsp");

        //当配置了视图解析器后，可以指定逻辑名称(文件名)，指定视图
        //框架会使用视图解析器的前缀+逻辑名称+后缀 组成完整的路径，这里就是字符连接操作
        ///WEB-INF/view/ + show + .jsp
        mv.setViewName("show");
        return mv;

    }

    @RequestMapping(value = {"/other.do","/second.do"}) //这里/代表项目的根，即http://localhost:8080/
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        //添加的对象，框架最后会把数据放入到request作用域中
        //相当于request.setAttribute("key",value)
        mv.addObject("msg","欢迎使用springMVC做开发");
        mv.addObject("fun","执行的是doSome方法");

        mv.setViewName("other");
        return mv;

    }
}
