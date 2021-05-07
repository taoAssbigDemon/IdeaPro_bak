package cn.taoass.web.serveltcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            ServletContext对象的获取
            1.通过request对象获取
            request.getServletContext();获取
            2.通过HttpServlet获取,HttpServlet继承了GenericServlet,而GenericServlet包含方法getServletContext();
            this.getServletContext();
         */
        //1.通过request获取
        ServletContext context1 = request.getServletContext();

        //2.通过HttpServlet获取
        ServletContext context2 = this.getServletContext();

        System.out.println(context1);
        System.out.println(context2);

        //判断这两个ServletContext是否相等
        System.out.println(context1 == context2);//true
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
