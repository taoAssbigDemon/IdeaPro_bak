package cn.taoass.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
        在服务器中的Servlet判断是否存在一个名为lastTime的cookie
    		1.有:不是第一次访问
                	1.响应数据：欢迎回来，您上次访问的时间为：上次访问的时间
                	2.写回cookie：lastTime=系统时间
             2.没有：是第一次访问
                	1.响应数据：您好，欢迎您首次访问
                	2.写回cookie：lastTime=系统时间
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体的数据格式及编码
        response.setContentType("text/html;charset=utf-8");

        //1.获取所有的cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false; //代表没有cookie
        //2.遍历cookies
        if( cookies != null && cookies.length>0){
            for (Cookie cookie : cookies) {
                //3.获取cookie的名称
                String name = cookie.getName();
                //4.判断名称是否是：lastTime
                if( "lastTime".equals(name)){
                    String value = cookie.getValue();

                    flag = true; //找到了，代表有cookie的name 为 lastTime
                    //有该cookie，表示不是第一次访问
                    //设置cookie的value
                    //获取当前的时间字符串，重新设置cookie值，重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//中文数据中的空格会导致服务器status=500
                    //解析时间
                    String str_date = sdf.format(date);

                    System.out.println("编码前："+str_date);
                    //URL编码
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    System.out.println("编码后："+str_date);

                    //设置cookie
                    cookie.setValue(str_date);
                    //发送cookie,Ps在发送cookie之前需要设置一个持久化存储
                    cookie.setMaxAge(60 * 60 * 24 * 30);//1mon
                    response.addCookie(cookie);

                    //响应数据
                    //获取cookie的value：也就是时间

                    //还需要进行URL解码
                    System.out.println("解码前："+value);
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后："+value);

                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间为："+value+"</h1>");

                    break;
                }
            }
        }

        if( cookies == null || cookies.length == 0 || flag == false ){
            //没有 lastTime cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            //解析时间
            String str_date = sdf.format(date);

            System.out.println("编码前："+str_date);
            //URL编码
            str_date = URLEncoder.encode(str_date,"utf-8");
            System.out.println("编码后："+str_date);

            //没有cookie，需要创建cookie
            Cookie cookie = new Cookie("lastTime",str_date);

            //设置cookie
            cookie.setValue(str_date);
            //发送cookie,Ps在发送cookie之前需要设置一个持久化存储
            cookie.setMaxAge(60 * 60 * 24 * 30);//1mon

            response.addCookie(cookie);

            //响应数据
            //获取cookie的value：也就是时间
            String value = cookie.getValue();
            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
