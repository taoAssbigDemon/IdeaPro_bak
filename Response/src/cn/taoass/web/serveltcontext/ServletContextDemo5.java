package cn.taoass.web.serveltcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            ServletContext对象的功能
            2.域对象:共享数据
            3.获取文件的真实(服务器)路径
         */

        //2.通过HttpServlet获取
        ServletContext context = this.getServletContext();
        //获取数据
        //获取文件的真实路径
        String realPath = context.getRealPath("/b.txt");
        System.out.println(realPath);
//        File file = new File(realPath);
        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
        System.out.println(c);

        String b = context.getRealPath("/WEB-INF/classes/b.txt");//src目录下的资源访问
        System.out.println(b);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
