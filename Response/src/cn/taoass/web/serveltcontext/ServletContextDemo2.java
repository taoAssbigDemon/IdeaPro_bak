package cn.taoass.web.serveltcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            ServletContext对象的功能
            1.获取MIME类型
            *MIME类型:在互联网数据传输过程中定义的一种文件数据类型
                *格式:    大类型/小类型     text/html   image/jpeg
                *获取:    String getMimeType(String file)

            2.域对象:共享数据
            3.获取文件的真实(服务器)路径
         */

        //2.通过HttpServlet获取
        ServletContext context = this.getServletContext();
        //3.定义文件名称
        String filename = "a.jpg";
        //4.获取Mime类型
        String mimeType = context.getMimeType("a.jpg");
        System.out.println(mimeType);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
