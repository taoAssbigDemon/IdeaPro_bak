package cn.taoass.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 完成功能：重定向
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //身份辨识度
        System.out.println("responseDemo1 被访问。");

        //访问/responseDemo1 会自动跳转到/responseDemo2资源
        /*//1.设置状态码为302（重定向状态码）
        response.setStatus(302);
        //2.设置响应头
        response.setHeader("location","/response/responseDemo2");*/

        //简单的重定向方法
        response.sendRedirect("/response/responseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
